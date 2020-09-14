package com.thoughtworks.capability.gtb.restfulapidesign.vo;

import com.thoughtworks.capability.gtb.restfulapidesign.entity.Student;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TeamVo {
    String name;
    String note;
}