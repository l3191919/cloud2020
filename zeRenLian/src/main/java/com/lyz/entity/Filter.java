package com.lyz.entity;


public interface Filter {
    void execute(Alarm alarm, FilterChain chain);
}
