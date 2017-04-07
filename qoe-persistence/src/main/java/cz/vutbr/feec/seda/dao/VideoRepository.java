package cz.vutbr.feec.seda.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import cz.vutbr.feec.seda.entity.Video;

/**
 * @author Pavel Šeda (441048)
 *
 */
public interface VideoRepository extends JpaRepository<Video, Long>, JpaSpecificationExecutor<Video> {

//	/**
//	 * select x randomly selected videos
//	 * @param pageable defined number of randomly selected videos
//	 * @return
//	 */
//	@Query("SELECT v FROM #{#entityName} v ORDER BY rand()") //SELECT v FROM #{#entityName} v ORDER BY rand()
//	public Page<Video> getRandomVideo(Pageable pageable);
	
	@Query(value = "SELECT * FROM video v ORDER BY RAND() LIMIT 1", nativeQuery = true)
	public Video getRandomVideo();
	
	@Override
	public Page<Video> findAll(Pageable pageRequest);
}
