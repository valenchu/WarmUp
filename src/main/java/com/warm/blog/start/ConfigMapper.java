package com.warm.blog.start;

import org.modelmapper.Conditions;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigMapper {
    @Bean
    public ModelMapper modelMapper() {

	ModelMapper modelMapper = new ModelMapper();
	modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STANDARD);
	modelMapper.getConfiguration().setPropertyCondition(Conditions.isNotNull());
	modelMapper.getConfiguration().setAmbiguityIgnored(true);
	return modelMapper;

    }
}
