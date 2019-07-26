package com.hj.express;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
@Data
public class UserbuyRelation implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;


    private Integer userId;


    private Integer productId;



    private String orderNo;

	private String serviceCode;			//服务编码（不同版本编码相同）

    private Integer serviceId;

    private Integer id;












    private String userName;


	private String productName;


}