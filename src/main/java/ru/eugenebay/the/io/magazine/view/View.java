package ru.eugenebay.the.io.magazine.view;

import lombok.Data;
import ru.eugenebay.the.io.magazine.common.InjectByType;
import ru.eugenebay.the.io.magazine.model.*;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

@Data
public class View {
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy - HH:mm:ss");
    private final AtomicLong atomicLong = new AtomicLong(0);
    @InjectByType
    private LabelView label;
    @InjectByType
    private PostView post;

    //TODO ?
    @PostConstruct
    public void foo() {
        var labels = label.getSettlerNamesList().stream()
                .map(name -> Label.builder()
                        .labelId(atomicLong.incrementAndGet())
                        .labelName(name)
                        .labelStatus(Status.ACTIVE)
                        .build())
                .collect(Collectors.toSet());
        atomicLong.set(0);
        var post = Post.builder()
                .postId(atomicLong.incrementAndGet())
                .content("Из одной системы нам еще долго не выбраться — из солнечной.")
                .postCreated(LocalDateTime.now().format(formatter))
                .labels(labels)
                .postStatus(PostStatus.ACTIVE)
                .build();
        atomicLong.set(0);
        var writer = Writer.builder()
                .writerId(atomicLong.incrementAndGet())
                .firstName("Станислав")
                .lastName("Ежи Лец")
                .posts(List.of(post))
                .status(Status.ACTIVE)
                .build();
        System.out.println("View@PostConstruct: " + writer);
    }
}
