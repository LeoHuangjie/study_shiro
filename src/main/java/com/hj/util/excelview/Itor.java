/**
 * TODO(用一句话描述该文件做什么)
 *
 * @author guoruifang
 * @date 2017年10月31日 20:20
 * @version v1.00
 * @since
 */
package com.hj.util.excelview;



import com.hj.util.excelview.util.ExcelValue;

import java.util.List;

public interface Itor {
    long total();

    List<List<ExcelValue>> fetch(int pageNo, int pageSize);
}
