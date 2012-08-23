/*
 * Copyright 2004 original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.safetys.framework.jmesa.model.tag;

import static com.safetys.framework.jmesa.model.tag.TagUtils.getColumnCellEditor;
import static com.safetys.framework.jmesa.model.tag.TagUtils.getColumnCellRenderer;
import static com.safetys.framework.jmesa.model.tag.TagUtils.getColumnFilterEditor;
import static com.safetys.framework.jmesa.model.tag.TagUtils.getColumnFilterRenderer;
import static com.safetys.framework.jmesa.model.tag.TagUtils.getColumnHeaderEditor;
import static com.safetys.framework.jmesa.model.tag.TagUtils.getColumnHeaderRenderer;
import static com.safetys.framework.jmesa.model.tag.TagUtils.getColumnSortOrder;
import static com.safetys.framework.jmesa.model.tag.TagUtils.getColumnWorksheetEditor;
import static com.safetys.framework.jmesa.model.tag.TagUtils.getWorksheetValidations;

import java.io.IOException;
import java.io.StringWriter;
import java.util.Collection;
import java.util.Map;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import com.safetys.framework.jmesa.util.ItemUtils;
import com.safetys.framework.jmesa.view.editor.CellEditor;
import com.safetys.framework.jmesa.view.editor.FilterEditor;
import com.safetys.framework.jmesa.view.editor.HeaderEditor;
import com.safetys.framework.jmesa.view.html.component.HtmlColumn;
import com.safetys.framework.jmesa.view.html.component.HtmlRow;
import com.safetys.framework.jmesa.view.html.renderer.HtmlCellRenderer;
import com.safetys.framework.jmesa.view.html.renderer.HtmlFilterRenderer;
import com.safetys.framework.jmesa.view.html.renderer.HtmlHeaderRenderer;
import com.safetys.framework.jmesa.worksheet.WorksheetValidation;
import com.safetys.framework.jmesa.worksheet.editor.WorksheetEditor;

/**
 * Represents an HtmlColumn.
 * 
 * @since 2.1
 * @author jeff jie
 */
public class HtmlColumnTag extends SimpleTagSupport {
    private String property;
    private String title;
    private String titleKey;
    private Boolean sortable;
    private String sortOrder;
    private Boolean filterable;
    private Boolean editable;
    private String worksheetEditor;
    private String width;
    private String cellRenderer;
    private String filterRenderer;
    private String headerRenderer;
    private String style;
    private String styleClass;
    private String filterStyle;
    private String filterClass;
    private String headerStyle;
    private String headerClass;
    private String pattern;
    private String cellEditor;
    private String headerEditor;
    private String filterEditor;
    private String worksheetValidation;
    private String customWorksheetValidation;
    private String errorMessageKey;
    private String errorMessage;

    public String getProperty() {
        return property;
    }

    public void setProperty(String property) {
        this.property = property;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitleKey() {
        return titleKey;
    }

    public void setTitleKey(String titleKey) {
        this.titleKey = titleKey;
    }

    public Boolean isSortable() {
        return sortable;
    }

    public void setSortable(Boolean sortable) {
        this.sortable = sortable;
    }

    /**
     * @since 2.2
     * @return The sort order for the column.
     */
    public String getSortOrder() {
        return sortOrder;
    }

    /**
     * @since 2.2
     * @param sortOrder The order array.
     */
    public void setSortOrder(String sortOrder) {
        this.sortOrder = sortOrder;
    }

    public Boolean isFilterable() {
        return filterable;
    }

    public void setFilterable(Boolean filterable) {
        this.filterable = filterable;
    }
    
    /**
     * @since 2.3
     */
    public Boolean isEditable() {
        return editable;
    }

    /**
     * @since 2.3
     */
    public void setEditable(Boolean editable) {
        this.editable = editable;
    }

    public String getWorksheetEditor() {
        return worksheetEditor;
    }

    public void setWorksheetEditor(String worksheetEditor) {
        this.worksheetEditor = worksheetEditor;
    }

    public String getWidth() {
        return width;
    }

    public void setWidth(String width) {
        this.width = width;
    }

    /**
     * @since 2.2
     */
    public String getCellRenderer() {
        return cellRenderer;
    }

    /**
     * @since 2.2
     */
    public void setCellRenderer(String cellRenderer) {
        this.cellRenderer = cellRenderer;
    }

    /**
     * @since 2.2
     */
    public String getFilterRenderer() {
        return filterRenderer;
    }

    /**
     * @since 2.2
     */
    public void setFilterRenderer(String filterRenderer) {
        this.filterRenderer = filterRenderer;
    }

    /**
     * @since 2.2
     */
    public String getHeaderRenderer() {
        return headerRenderer;
    }

    /**
     * @since 2.2
     */
    public void setHeaderRenderer(String headerRenderer) {
        this.headerRenderer = headerRenderer;
    }

    /**
     * @since 2.2.1
     */
    public String getStyle() {
        return style;
    }

    /**
     * @since 2.2.1
     */
    public void setStyle(String style) {
        this.style = style;
    }

    /**
     * @since 2.2.1
     */
    public String getStyleClass() {
        return styleClass;
    }

    /**
     * @since 2.2.1
     */
    public void setStyleClass(String styleClass) {
        this.styleClass = styleClass;
    }

    /**
     * @since 2.2
     */
    public String getFilterStyle() {
        return filterStyle;
    }

    /**
     * @since 2.2
     */
    public void setFilterStyle(String filterStyle) {
        this.filterStyle = filterStyle;
    }

    /**
     * @since 2.2
     */
    public String getFilterClass() {
        return filterClass;
    }

    /**
     * @since 2.2
     */
    public void setFilterClass(String filterClass) {
        this.filterClass = filterClass;
    }

    /**
     * @since 2.2
     */
    public String getHeaderStyle() {
        return headerStyle;
    }

    /**
     * @since 2.2
     */
    public void setHeaderStyle(String headerStyle) {
        this.headerStyle = headerStyle;
    }

    /**
     * @since 2.2
     */
    public String getHeaderClass() {
        return headerClass;
    }

    /**
     * @since 2.2
     */
    public void setHeaderClass(String headerClass) {
        this.headerClass = headerClass;
    }

    public String getPattern() {
        return pattern;
    }

    public void setPattern(String pattern) {
        this.pattern = pattern;
    }

    public String getCellEditor() {
        return cellEditor;
    }

    public void setCellEditor(String cellEditor) {
        this.cellEditor = cellEditor;
    }

    /**
     * @since 2.2
     * @return The header editor for the column.
     */
    public String getHeaderEditor() {
        return headerEditor;
    }

    /**
     * @since 2.2
     * @param headerEditor The header editor to use.
     */
    public void setHeaderEditor(String headerEditor) {
        this.headerEditor = headerEditor;
    }

    /**
     * @since 2.2
     * @return The filter editor for the column.
     */
    public String getFilterEditor() {
        return filterEditor;
    }

    /**
     * @since 2.2
     * @param filterEditor The filter editor to use.
     */
    public void setFilterEditor(String filterEditor) {
        this.filterEditor = filterEditor;
    }

    /**
     * @since 2.6.7
     */
    public String getWorksheetValidation() {
        return worksheetValidation;
    }

    /**
     * @since 2.6.7
     * @param worksheetValidation The worksheet validation to use.
     */
    public void setWorksheetValidation(String worksheetValidation) {
        this.worksheetValidation = worksheetValidation;
    }

    /**
     * @since 2.6.7
     */
    public String getCustomWorksheetValidation() {
        return customWorksheetValidation;
    }

    /**
     * @since 2.6.7
     * @param customWorksheetValidation The custom worksheet validation to use.
     */
    public void setCustomWorksheetValidation(String customWorksheetValidation) {
        this.customWorksheetValidation = customWorksheetValidation;
    }

    /**
     * @since 2.6.7
     */

    public String getErrorMessageKey() {
        return errorMessageKey;
    }

    /**
     * @since 2.6.7
     * @param errorMessageKey Error message key for worksheet validation.
     */

    public void setErrorMessageKey(String errorMessageKey) {
        this.errorMessageKey = errorMessageKey;
    }

    /**
     * @since 2.6.7
     */

    public String getErrorMessage() {
        return errorMessage;
    }

    /**
     * @since 2.6.7
     * @param errorMessage Error message for worksheet validation.
     */

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    /**
     * The column to use. If the column does not exist then one will be created.
     */
    private HtmlColumn getHtmlColumn() {
        HtmlColumn htmlColumn = new HtmlColumn(getProperty());
        
        htmlColumn.setTitle(getTitle());
        htmlColumn.setTitleKey(getTitleKey());
        htmlColumn.setSortable(isSortable());
        htmlColumn.setSortOrder(getColumnSortOrder(getSortOrder()));
        htmlColumn.setFilterable(isFilterable());
        htmlColumn.setEditable(isEditable());
        htmlColumn.setWidth(getWidth());
        htmlColumn.setStyle(getStyle());
        htmlColumn.setStyleClass(getStyleClass());
        htmlColumn.setFilterStyle(getFilterStyle());
        htmlColumn.setFilterClass(getFilterClass());
        htmlColumn.setHeaderStyle(getHeaderStyle());
        htmlColumn.setHeaderClass(getHeaderClass());

        // cell
        
        HtmlCellRenderer cr = getColumnCellRenderer(htmlColumn, getCellRenderer());
        htmlColumn.setCellRenderer(cr);

        CellEditor ce = getColumnCellEditor(htmlColumn, getCellEditor(), getPattern(), getJspBody() != null);
        htmlColumn.setCellEditor(ce);

        // filter

        HtmlFilterRenderer fr = getColumnFilterRenderer(htmlColumn, getFilterRenderer());
        htmlColumn.setFilterRenderer(fr);

        FilterEditor fe = getColumnFilterEditor(htmlColumn, getFilterEditor());
        htmlColumn.setFilterEditor(fe);

        // header

        HtmlHeaderRenderer hr = getColumnHeaderRenderer(htmlColumn, getHeaderRenderer());
        htmlColumn.setHeaderRenderer(hr);

        HeaderEditor he = getColumnHeaderEditor(htmlColumn, getHeaderEditor());
        htmlColumn.setHeaderEditor(he);
        
        // worksheet

        WorksheetEditor we = getColumnWorksheetEditor(htmlColumn, getWorksheetEditor());
        htmlColumn.setWorksheetEditor(we);

        for (WorksheetValidation wsv : getWorksheetValidations(htmlColumn, getWorksheetValidation(),
                getErrorMessageKey(), getErrorMessage(), false)) {
            htmlColumn.addWorksheetValidation(wsv);
        }
        for (WorksheetValidation wsv : getWorksheetValidations(htmlColumn, getCustomWorksheetValidation(),
                getErrorMessageKey(), getErrorMessage(), true)) {
            htmlColumn.addWorksheetValidation(wsv);
        }

        return htmlColumn;
    }

    /**
     * If a ColumnTag body is defined then use it as the current page item value. If it is not
     * defined then get the page item value from the regular bean by using the property
     * 
     * @return The item to use.
     */
    private Object getValue() throws JspException, IOException {
        TableModelTag facadeTag = (TableModelTag) findAncestorWithClass(this, TableModelTag.class);
        String var = facadeTag.getVar();
        Object item = getJspContext().getAttribute(var);

        if (item == null) {
            return null;
        }

        JspFragment body = getJspBody();
        if (body == null) {
            return ItemUtils.getItemValue(item, getProperty());
        }

        StringWriter value = new StringWriter();
        body.invoke(value);
        return value;
    }

    @Override
    public void doTag() throws JspException, IOException {
        TableModelTag facadeTag = (TableModelTag) findAncestorWithClass(this, TableModelTag.class);
        Collection<Map<String, Object>> pageItems = facadeTag.getPageItems();
        if (pageItems.size() == 1) {
            HtmlRow htmlRow = facadeTag.getTable().getRow();
            HtmlColumn htmlColumn = getHtmlColumn();
            TagUtils.validateColumn(this, getProperty());
            htmlRow.addColumn(htmlColumn);
        }

        HtmlRowTag rowTag = (HtmlRowTag) findAncestorWithClass(this, HtmlRowTag.class);
        Map<String, Object> pageItem = rowTag.getPageItem();
        pageItem.put(getProperty(), getValue());
    }
}
