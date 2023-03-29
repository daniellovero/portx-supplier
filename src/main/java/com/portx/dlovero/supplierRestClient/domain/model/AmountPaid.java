package com.portx.dlovero.supplierRestClient.domain.model;

import java.math.BigDecimal;

/**
 * @param currency This can be a set of values defined by extension instead of string.
 */
public record AmountPaid(BigDecimal amount, String currency) {
}
