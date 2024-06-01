package com.github.youz.report.converter.export;

import com.github.youz.report.export.bo.DynamicColumn;

import java.lang.reflect.Field;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 动态数据
 */
public class ExportDynamicConverter implements ExportConverter {

    @Override
    public boolean supports(Field field, Object target) {
        return field.getType().isAssignableFrom(List.class);
    }

    @Override
    public Object convert2Excel(Field field, Object target) {
        List<DynamicColumn> items = (List<DynamicColumn>) target;
        return items.stream().map(DynamicColumn::getData).collect(Collectors.toList());
    }
}
