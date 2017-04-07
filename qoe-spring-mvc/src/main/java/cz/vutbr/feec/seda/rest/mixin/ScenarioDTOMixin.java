package cz.vutbr.feec.seda.rest.mixin;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({ "video", "mos"})
public class ScenarioDTOMixin {

}
