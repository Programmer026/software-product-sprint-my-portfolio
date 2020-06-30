// Copyright 2019 Google LLC
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//     https://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package com.google.sps;

import java.util.Collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public final class FindMeetingQuery {
    
  public Collection<TimeRange> query(Collection<Event> events, MeetingRequest request) {
    //throw new UnsupportedOperationException("TODO: Implement this method.");
    Collection<TimeRange> times = Collections.emptySet();
    if( (request.getAttendees()).isEmpty() ) {
        times = Arrays.asList(TimeRange.WHOLE_DAY);    
    }
    if(request.getDuration() > 1440){
        times = Arrays.asList();
    }
    for(Event event : events){
        TimeRange time = event.getWhen();
        times = Arrays.asList( TimeRange.fromStartEnd(TimeRange.START_OF_DAY, time.start() ,false), 
        TimeRange.fromStartEnd(time.end(), TimeRange.END_OF_DAY, true) );
    }
    return times;

    ArrayList<TimeRange> arrList = new ArrayList<>();
    for (Event event : events){
        TimeRange time = event.getWhen();
        arrList.add(time);
    }
    Collections.sort(arrList, TimeRange.ORDER_BY_START);
  }
}

