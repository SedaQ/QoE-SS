package cz.vutbr.feec.seda.rest.mixin;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({ "questionary", "video", "scenario"})
public class MosDTOMixin {

}
