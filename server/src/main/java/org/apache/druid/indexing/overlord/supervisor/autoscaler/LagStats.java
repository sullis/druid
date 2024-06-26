/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.apache.druid.indexing.overlord.supervisor.autoscaler;

public class LagStats
{
  private final long maxLag;
  private final long totalLag;
  private final long avgLag;

  public LagStats(long maxLag, long totalLag, long avgLag)
  {
    this.maxLag = maxLag;
    this.totalLag = totalLag;
    this.avgLag = avgLag;
  }

  public long getMaxLag()
  {
    return maxLag;
  }

  public long getTotalLag()
  {
    return totalLag;
  }

  public long getAvgLag()
  {
    return avgLag;
  }

  public long get(LagMetric metric)
  {
    switch (metric) {
      case AVERAGE:
        return avgLag;
      case TOTAL:
        return totalLag;
      case MAX:
        return maxLag;
    }
    throw new IllegalStateException("Unknown Metric");
  }
}
