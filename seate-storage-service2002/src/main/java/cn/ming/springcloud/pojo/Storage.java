package cn.ming.springcloud.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: ming
 * @create: 2020/11/6 0:04
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Storage {
    private Long id;

    private Integer total;

    private Integer used;

    private Integer  residue;
}
