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
package com.safetys.framework.jmesa.view.renderer;

import com.safetys.framework.jmesa.view.component.Column;
import com.safetys.framework.jmesa.view.editor.FilterEditor;

/**
 * @since 2.0
 * @author Jeff Johnston
 */
public interface FilterRenderer {
    public Column getColumn();

    public void setColumn(Column column);

    /**
     * @deprecated Should get/set the value on the Column.
     */
    @Deprecated
    public FilterEditor getFilterEditor();

    /**
     * @deprecated Should get/set the value on the Column.
     */
    @Deprecated
    public void setFilterEditor(FilterEditor filterEditor);

    public Object render();
}
