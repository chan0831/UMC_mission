package umc.study.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QReview_Image is a Querydsl query type for Review_Image
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QReview_Image extends EntityPathBase<Review_Image> {

    private static final long serialVersionUID = -2095740010L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QReview_Image review_Image = new QReview_Image("review_Image");

    public final umc.study.domain.common.QBaseEntity _super = new umc.study.domain.common.QBaseEntity(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath image_url = createString("image_url");

    public final QReview review;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public QReview_Image(String variable) {
        this(Review_Image.class, forVariable(variable), INITS);
    }

    public QReview_Image(Path<? extends Review_Image> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QReview_Image(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QReview_Image(PathMetadata metadata, PathInits inits) {
        this(Review_Image.class, metadata, inits);
    }

    public QReview_Image(Class<? extends Review_Image> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.review = inits.isInitialized("review") ? new QReview(forProperty("review"), inits.get("review")) : null;
    }

}

