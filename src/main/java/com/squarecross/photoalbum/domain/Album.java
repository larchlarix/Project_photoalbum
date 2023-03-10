//Album 데이터 베이스 객체 정의

package com.squarecross.photoalbum.domain;

import javax.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import java.util.Date;
import java.util.List;

//테이블 정보 및 매핑해주기
//uniqueConstraints: 반복되면 안되는 제약조건
//unique: 중복불가
//nullable: null 값 허용
@Entity
@Table(name="album", schema = "photo_album", uniqueConstraints = {@UniqueConstraint(columnNames = "album_id")})
public class Album {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "album_id", unique = true, nullable = false)
    private  Long albumId;

    @Column(name = "album_name", unique = true, nullable = false)
    private String albumName;

    @Column(name = "created_at", unique = true, nullable = false)
    @CreationTimestamp
    private Date createdAt;

    public Album(){};

    public Long getAlbumId() {
        return albumId;
    }

    public void setAlbumId(Long albumId) {
        this.albumId = albumId;
    }


    public String getAlbumName() {
        return albumName;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    //mappedBy FK의 주인이 아닐 경우 사용, FK의 주인은 Photo 이다.
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "album")
    private List<Photo> photos;

    public List<Photo> getPhotos() {
        return photos;
    }

    public void setPhotos(List<Photo> photos) {
        this.photos = photos;
    }
}
