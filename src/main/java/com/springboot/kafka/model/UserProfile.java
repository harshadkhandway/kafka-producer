package com.springboot.kafka.model;

import java.io.Serializable;

public record UserProfile (String firstName, String lastName) implements Serializable {};
