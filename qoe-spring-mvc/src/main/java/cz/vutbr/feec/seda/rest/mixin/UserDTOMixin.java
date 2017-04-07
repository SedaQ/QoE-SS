package cz.vutbr.feec.seda.rest.mixin;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({ "passwordHash"})
public class UserDTOMixin {

}
