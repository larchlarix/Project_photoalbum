package com.squarecross.photoalbum.service;

import com.squarecross.photoalbum.domain.Album;
import org.springframework.stereotype.Service;
import com.squarecross.photoalbum.repository.AlbumRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;
@Service  // 어노테이션을 추가하여 Bean으로 등록하여 IoC컨테이너에 추가
public class AlbumService {
    @Autowired  // 어노테이션을 등록된 빈을 컨테이너에서 가져와서 사용할 수 있음
                // AlbumRepository 클래스를 빈으로 등록했으니 @Autowired 어노테이션 아래 클래스명인 AlbumRepository 필드를 정의해주면
               // Spring IoC에 생성된 Bean을 자동으로 가져옵
    private AlbumRepository albumRepository;

    public Album getAlbum(Long albumId){
        Optional<Album> res = albumRepository.findById(albumId);
        if (res.isPresent()){
            return res.get();
        }else{
            throw new EntityNotFoundException(String.format("앨범 아이디 %d로 조회되지 않았습니다", albumId));
        }
    }
}
