package com.inditex.application.contract;

public interface Mapper<T, V> {

	V map(T input);
}
