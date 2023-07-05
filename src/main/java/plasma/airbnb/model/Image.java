package plasma.airbnb.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "image")
@Data
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "imageData")
    private String imageData;

    @Temporal(TemporalType.TIMESTAMP)
    private Date uploadDate;

    // Ранее я делал код таким чтоюы можно было описать несколько полей
    // но как вижу мы не использовали некоторые, ради оптимизации прощу вас удалить лишний код
    @Column(name = "original_file_name")
    private String originalFileName;

    @Column(name = "size")
    private Long size;

    @Column(name = "content_type")
    private String contentType;

    @Column(name = "is_preview_image")
    private boolean isPreviewImage;
    // Думаю байт можно удалить проверьте не выйдет ли ошибка
    @Lob
    private byte[] bytes;

    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    private Product product;

    @OneToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    private User user;

    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    private FeedBack feedBack;
}