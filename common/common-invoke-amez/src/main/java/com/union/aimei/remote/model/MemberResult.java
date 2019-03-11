package com.union.aimei.remote.model;


import lombok.Data;
import lombok.NoArgsConstructor;

/** 
  * @author GaoWei
  * @Date 18-8-13 下午4:03
  * @description
  */
@Data
@NoArgsConstructor
public class MemberResult {

    private Boolean hasPassword;
    private Boolean hasPayPassword;
    private AmezMember member;
}
