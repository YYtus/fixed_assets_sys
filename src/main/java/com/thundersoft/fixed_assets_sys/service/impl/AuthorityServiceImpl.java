package com.thundersoft.fixed_assets_sys.service.impl;


import com.thundersoft.fixed_assets_sys.entity.Fixed_assets_authority;
import com.thundersoft.fixed_assets_sys.mapper.authorityMapper;
import com.thundersoft.fixed_assets_sys.service.authorityService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
@Slf4j
public class AuthorityServiceImpl implements authorityService {

    @Resource
    private authorityMapper authorityMapper;
    @Override
    public List<Fixed_assets_authority> getMenus() {
        String username =
                SecurityContextHolder.getContext().
                        getAuthentication().getPrincipal().toString();
//        authority为查询当前角色的权限
        List<Fixed_assets_authority> authority = authorityMapper.findAuthorityByCurrentUser(username);

        authority.forEach(p->{
            List<Fixed_assets_authority> children = authorityMapper.findAuthorityByA_parent(p.getA_id(),username);
      //  children.forEach(m->{});
       //     children.removeIf(p->p.getA_parent()==0);
            p.setChildren(children);
        });
        authority.removeIf(p->p.getA_parent()!=0);
        // [{children: []},{}]
        log.info("list"+authority);
        return authority;
    }
}
