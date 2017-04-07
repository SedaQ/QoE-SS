package cz.vutbr.feec.seda.rest.mixin;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({ "mos", "scenario"})
public class VideoDTOMixin {

}
