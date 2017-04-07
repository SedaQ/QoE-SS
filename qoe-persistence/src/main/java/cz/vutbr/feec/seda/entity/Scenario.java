package cz.vutbr.feec.seda.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import cz.vutbr.feec.seda.entity.ScenarioParameters;

/**
 * @author Pavel Šeda (441048)
 *
 */
@Entity
@Table(name = "scenario")
public class Scenario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_scenarion", nullable = false, unique = true)
	private Long id;

	@Column(nullable = false)
	private String scenario;

	@ManyToMany(fetch = FetchType.EAGER)
	private Set<Video> video = new HashSet<Video>();

	@ManyToMany(mappedBy = "scenario", fetch = FetchType.EAGER)
	private Set<ScenarioParameters> scenarioparameters = new HashSet<ScenarioParameters>();
	
	@OneToOne(optional = true, mappedBy="scenario", fetch = FetchType.EAGER)
	private Mos mos;

	public Scenario() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getScenario() {
		return scenario;
	}

	public void setScenario(String scenario) {
		this.scenario = scenario;
	}

	public Set<Video> getVideo() {
		return video;
	}

	public void setVideo(Set<Video> video) {
		this.video = video;
	}

	public void addVideo(Video video) {
		this.video.add(video);
	}


	public Set<ScenarioParameters> getScenarioparameters() {
		return scenarioparameters;
	}

	public void setScenarioparameters(Set<ScenarioParameters> scenarioparameters) {
		this.scenarioparameters = scenarioparameters;
	}
	
	public void addScenarioParameter(ScenarioParameters scenarioParameter){
		this.scenarioparameters.add(scenarioParameter);
	}

	public Mos getMos() {
		return mos;
	}

	public void setMos(Mos mos) {
		this.mos = mos;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((scenario == null) ? 0 : scenario.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Scenario))
			return false;
		Scenario other = (Scenario) obj;
		if (id == null) {
			if (other.getId() != null)
				return false;
		} else if (!id.equals(other.getId()))
			return false;
		if (scenario == null) {
			if (other.getScenario() != null)
				return false;
		} else if (!scenario.equals(other.getScenario()))
			return false;
		return true;
	}

}
