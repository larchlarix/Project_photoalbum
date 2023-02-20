package com.squarecross.photoalbum.domain;

import javax.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import java.util.Date;

//테이블 정보 매핑 해주기
//uniqueConstraints: 반복되면 안되는 제약조건
//unique: 중복불가
//nullable: null 값 허용
@Entity
@Table(name = "photo", schema = "photo_album", uniqueConstraints = {@UniqueConstraint(columnNames = "photo_id")} )
public class Photo {

    @Id     //해당 Entity의 Primary Key로 사용한다는 의미, 같은 테이블 내 중복될 값 없음
    @GeneratedValue(strategy = GenerationType.IDENTITY)  //@GeneratedValue: id값 새로 부여할때 사용하는 방법
                                                        //strategy = GenerationType.IDENTITY: 가장 최근 id에 +1 을 해서 다음 아이디를 생성
    @Column(name = "photo_id", unique = true, nullable = false) // 열 생성
    private Long photoId;

    @Column(name = "file_name", unique = true, nullable = true)
    private String fileName;

    @Column(name = "thumb_url", unique = true, nullable = true)
    private String thumbUrl;

    @Column(name = "original_url", unique = true, nullable = true)
    private String originalUrl;

    @Column(name = "file_size", unique = true, nullable = true)
    private Long fileSize;

    @Column(name = "uploaded_at", unique = true, nullable = true)
    @CreationTimestamp
    private Date uploadedAt;

    public Long getPhotoId() {
        return photoId;
    }

    public void setPhotoId(Long photoId) {
        this.photoId = photoId;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getThumbUrl() {
        return thumbUrl;
    }

    public void setThumbUrl(String thumbUrl) {
        this.thumbUrl = thumbUrl;
    }

    public String getOriginalUrl() {
        return originalUrl;
    }

    public void setOriginalUrl(String originalUrl) {
        this.originalUrl = originalUrl;
    }

    public Long getFileSize() {
        return fileSize;
    }

    public void setFileSize(Long fileSize) {
        this.fileSize = fileSize;
    }

    public Date getUploadedAt() {
        return uploadedAt;
    }

    public void setUploadedAt(Date uploadedAt) {
        this.uploadedAt = uploadedAt;
    }

    //@ManyToOne:FK를 설정할 때 Entity끼리 어떤 관계를 가지고 있는지에 대한 정보
    //여러개의 포토가 하나의 앨범에 속해있기 때문에 @ManyToOne사용
    //fetch = FetchType.LAZY, 지연로딩으로 Album정보가 필요할 때만 불러옴
    //불필요한 데이터 조회x, 앨범 정보 조회할 일 있을 때만 별도로 쿼리 보냄

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "album_id")  //앨범의 PK를 참조, 따라서 name=”album_id” 값을 넣어줌.
    private Album album;

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }
}
