package com.mitemitreski.blog.performace.java;

import com.google.caliper.BeforeExperiment;
import com.google.caliper.Benchmark;
import com.google.caliper.Param;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import java.util.*;

/**
 * Tests related to HashMap defaultSize.
 */
public class HashMapSizeBenchmark {


  @Param({"0", "100", "1000"})
  private int length;

  @Param
  private Distribution distribution;

  private List<Integer> items;

  public enum Distribution {

    SAWTOOTH {
      @Override
      List<Integer> create(int length) {
        List<Integer> result = Lists.newArrayList(length);
        for (int i = 0; i < length; i += 5) {
          result.add(i, 0);
          result.add(i + 1, 1);
          result.add(i + 2, 2);
          result.add(i + 3, 3);
          result.add(i + 4, 4);
        }
        return result;
      }
    },
    INCREASING {
      @Override
      List<Integer> create(int length) {
        List<Integer> result = Lists.newArrayList(length);
        for (int i = 0; i < length; i++) {
          result.add(i, i);
        }
        return result;
      }
    },
    DECREASING {
      @Override
      List<Integer> create(int length) {
        List<Integer> result = Lists.newArrayList(length);
        for (int i = 0; i < length; i++) {
          result.add(i, length - i);
        }
        return result;
      }
    },
    RANDOM {
      @Override
      List<Integer> create(int length) {
        List<Integer> result = Lists.newArrayList(length);
        Random random = new Random();
        for (int i = 0; i < length; i++) {
          result.add(i, random.nextInt());
        }
        return result;
      }

    };
    abstract List<Integer> create(int length);
  }


  @BeforeExperiment
  void setUp() {
    this.items = distribution.create(length);
  }

  @Benchmark
  Map<Integer, Integer> non_initialized_size_map(int reps) {
    Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    for (int i = 0; i < reps; i++) {
      for (Integer item : items) {
        map.put(item, item);
      }
    }
    return map;
  }

  @Benchmark
  Map<Integer, Integer> initialized_size_length_with_full_map(int reps) {
    Map<Integer, Integer> map = new HashMap<Integer, Integer>(1 + (int) (length / 0.75));
    for (int i = 0; i < reps; i++) {
      for (Integer item : items) {
        map.put(item, item);
      }
    }
    return map;
  }

  /**
   * By the javadoc it should be the same behaviour as JDK 1.6 with inital size
   */
  @Benchmark
  Map<Integer, Integer> initialized_guava_defaults(int reps) {
    Map<Integer, Integer> map = Maps.newHashMapWithExpectedSize(length);
    for (int i = 0; i < reps; i++) {
      for (Integer item : items) {
        map.put(item, item);
      }
    }
    return map;
  }
}

