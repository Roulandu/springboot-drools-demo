package com.roulandu.rule.pojo.drools;

import lombok.Builder;
import lombok.Data;

/** Created By QQ497 on 2019/9/25 */
@Data
@Builder
public class VerifyResult {
  private boolean result;
  private Object data;
}
