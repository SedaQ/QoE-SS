package cz.vutbr.feec.seda.rest.mixin;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({ "questionary", "mos"})
public class QuestionaryDTOMixin {

}
