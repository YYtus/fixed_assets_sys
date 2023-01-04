package com.thundersoft.fixed_assets_sys.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Fixed_assets_authority {
    private Integer a_id;
    private String a_text;
    private Integer a_parent;
    private String a_path;
    private String a_component;
    private List<Fixed_assets_authority> children;

}
