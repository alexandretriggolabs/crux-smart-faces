/*
 * Copyright 2014 cruxframework.org.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package org.cruxframework.crux.smartfaces.client.grid;

import org.cruxframework.crux.core.client.dataprovider.PagedDataProvider;
import org.cruxframework.crux.core.client.event.HasSelectHandlers;
import org.cruxframework.crux.core.client.event.SelectHandler;
import org.cruxframework.crux.core.client.factory.DataFactory;
import org.cruxframework.crux.core.shared.Experimental;

import com.google.gwt.event.dom.client.BlurHandler;
import com.google.gwt.event.dom.client.FocusHandler;
import com.google.gwt.event.dom.client.HasAllFocusHandlers;
import com.google.gwt.event.dom.client.HasAllMouseHandlers;
import com.google.gwt.event.dom.client.MouseDownHandler;
import com.google.gwt.event.dom.client.MouseMoveHandler;
import com.google.gwt.event.dom.client.MouseOutHandler;
import com.google.gwt.event.dom.client.MouseOverHandler;
import com.google.gwt.event.dom.client.MouseUpHandler;
import com.google.gwt.event.dom.client.MouseWheelHandler;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.ui.HasEnabled;

//CHECKSTYLE:OFF
/**
 * @author Samuel Almeida Cardoso (samuel@cruxframework.org)	
 *
 * @param <T>
 * - EXPERIMENTAL - 
 * THIS CLASS IS NOT READY TO BE USED IN PRODUCTION. IT CAN CHANGE FOR NEXT RELEASES
 */
@Experimental
public class DataGrid<T> extends PageableDataGrid<T> implements HasAllFocusHandlers, HasEnabled, HasSelectHandlers, HasAllMouseHandlers
{
	public DataGrid(PagedDataProvider<T> dataProvider, boolean autoLoadData)
    {
	    super(dataProvider, autoLoadData);
    }

	@Override
    public HandlerRegistration addFocusHandler(FocusHandler handler)
    {
	    // TODO Auto-generated  method stub
	    return null;
    }

	@Override
    public HandlerRegistration addBlurHandler(BlurHandler handler)
    {
	    // TODO Auto-generated method stub
	    return null;
    }

	@Override
    public boolean isEnabled()
    {
	    // TODO Auto-generated method stub
	    return false;
    }

	@Override
    public void setEnabled(boolean enabled)
    {
	    // TODO Auto-generated method stub
	    
    }

	@Override
    public HandlerRegistration addSelectHandler(SelectHandler handler)
    {
	    // TODO Auto-generated method stub
	    return null;
    }

	@Override
    public HandlerRegistration addMouseDownHandler(MouseDownHandler handler)
    {
	    // TODO Auto-generated method stub
	    return null;
    }

	@Override
    public HandlerRegistration addMouseUpHandler(MouseUpHandler handler)
    {
	    // TODO Auto-generated method stub
	    return null;
    }

	@Override
    public HandlerRegistration addMouseOutHandler(MouseOutHandler handler)
    {
	    // TODO Auto-generated method stub
	    return null;
    }

	@Override
    public HandlerRegistration addMouseOverHandler(MouseOverHandler handler)
    {
	    // TODO Auto-generated method stub
	    return null;
    }

	@Override
    public HandlerRegistration addMouseMoveHandler(MouseMoveHandler handler)
    {
	    // TODO Auto-generated method stub
	    return null;
    }

	@Override
    public HandlerRegistration addMouseWheelHandler(MouseWheelHandler handler)
    {
	    // TODO Auto-generated method stub
	    return null;
    }

	public <V> DataGrid<T>.Column<V> newColumn(DataFactory<V,T> dataFactory)
    {
	    PageableDataGrid<T>.Column<V> column = new Column<V>(dataFactory);
	    addColumn(column);
		return column;
    }
}
