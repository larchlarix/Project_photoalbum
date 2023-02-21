//데이터베이스에 접근하기 위한 메서드 정의

package com.squarecross.photoalbum.repository;

import com.squarecross.photoalbum.domain.Album;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository  // 어노테이션을 추가해서 스프링 Bean 으로 등록하여, IoC에서 관리하도록함
public interface AlbumRepository extends JpaRepository<Album,Long> {

}
