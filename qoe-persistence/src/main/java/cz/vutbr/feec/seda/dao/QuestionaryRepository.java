package cz.vutbr.feec.seda.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import cz.vutbr.feec.seda.entity.Questionary;

/**
 * @author Pavel Šeda (441048)
 *
 */
public interface QuestionaryRepository extends
		JpaRepository<Questionary, Long>, JpaSpecificationExecutor<Questionary> {

	/**
	 * 
	 * @param searchTerm search by email, gender, age, school or userConnection
	 * @return List of questionaries matches criteria above
	 */
	@Query(value = "SELECT * FROM questionary q WHERE "
			+ "LOWER (q.email) LIKE LOWER(CONCAT('%',:searchTerm, '%')) OR "
			+ "LOWER (q.gender) LIKE LOWER(CONCAT('%',:searchTerm, '%')) OR "
			+ "LOWER (q.age) LIKE LOWER(CONCAT(:searchTerm, '%')) OR "
			+ "LOWER (q.school) LIKE LOWER(CONCAT('%',:searchTerm, '%')) OR "
			+ "LOWER (q.user_connection) LIKE LOWER(CONCAT('%',:searchTerm, '%'))", nativeQuery = true)
	public java.util.List<Questionary> findAllBySearchTerm(@Param("searchTerm") String searchTerm);

	/**
	 * Find specific questionary by email
	 * 
	 * @param email
	 *            email to search in String format
	 * @return return specific user by his email
	 */
	@Query("SELECT q FROM #{#entityName} q WHERE q.email=:email")
	public Questionary findByEmail(@Param("email") String email);

}
