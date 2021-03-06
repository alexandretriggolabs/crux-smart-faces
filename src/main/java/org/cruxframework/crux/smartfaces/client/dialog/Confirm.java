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
package org.cruxframework.crux.smartfaces.client.dialog;


import org.cruxframework.crux.core.client.Crux;
import org.cruxframework.crux.core.client.event.CancelEvent;
import org.cruxframework.crux.core.client.event.CancelHandler;
import org.cruxframework.crux.core.client.event.HasCancelHandlers;
import org.cruxframework.crux.core.client.event.HasOkHandlers;
import org.cruxframework.crux.core.client.event.OkEvent;
import org.cruxframework.crux.core.client.event.OkHandler;
import org.cruxframework.crux.core.client.event.SelectEvent;
import org.cruxframework.crux.core.client.event.SelectHandler;
import org.cruxframework.crux.smartfaces.client.WidgetMsgFactory;
import org.cruxframework.crux.smartfaces.client.button.Button;
import org.cruxframework.crux.smartfaces.client.dialog.animation.DialogAnimation;
import org.cruxframework.crux.smartfaces.client.label.HTML;
import org.cruxframework.crux.smartfaces.client.panel.NavPanel;

import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.safehtml.shared.SafeHtml;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Widget;

/**
 * A simple confirm dialog box
 * @author Thiago da Rosa de Bustamante
 */
public class Confirm extends AbstractDialogBox implements HasOkHandlers, HasCancelHandlers
{
	public static final String DEFAULT_STYLE_NAMES = "faces-Confirm faces-popup";

	private HTML msgLabel;
	private Button okButton;
	private Button cancelButton;

	/**
	 * Creates a confirm
	 */
	public Confirm()
	{
		this(true, false, DEFAULT_STYLE_NAMES);
	}
	
	/**
	 * Creates a confirm dialog box
	 * @param movable if true, the window can be dragged
	 * @param resizable if true, the window can be resized
	 * @param modal if true this dialog disables events that does not target the dialog 
	 * @param styleName the dialog base CSS class name
	 */
	public Confirm(boolean movable, boolean resizable, String styleName)
	{
		super(movable, resizable, false, true, styleName);
		setStyleName(styleName);
		Widget content = createMessagePanel();
		super.setWidget(content);
	}
	
	/**
	 * Shows a confirm dialog
	 * @param title the text to be displayed as the caption of the confirm 
	 * @param message the text to be displayed in the body of the confirm
	 * @param okHandler a handler for the OK button click event
	 * @param cancelHandler a handler for the Cancel button click event
	 */
	public static Confirm show(String title, String message, OkHandler okHandler, CancelHandler cancelHandler)
	{
		return show(title, message, WidgetMsgFactory.getMessages().okLabel(), WidgetMsgFactory.getMessages().cancelLabel(), 
				okHandler, cancelHandler, DEFAULT_STYLE_NAMES, null);
	}
	
	/**
	 * Shows a confirm dialog
	 * @param title the text to be displayed as the caption of the confirm 
	 * @param message the text to be displayed in the body of the confirm
	 * @param okHandler a handler for the OK button click event
	 * @param cancelHandler a handler for the Cancel button click event
	 * @param movable if true, the window can be dragged
	 * @param resizable if true, the window can be resized
	 */
	public static Confirm show(String title, String message, OkHandler okHandler, CancelHandler cancelHandler, boolean movable, boolean resizable)
	{
		return show(title, message, WidgetMsgFactory.getMessages().okLabel(), WidgetMsgFactory.getMessages().cancelLabel(), 
				okHandler, cancelHandler, movable, resizable, DEFAULT_STYLE_NAMES, null);
	}
	
	/**
	 * Shows a confirm dialog
	 * @param title the text to be displayed as the caption of the confirm 
	 * @param message the text to be displayed in the body of the confirm
	 * @param okHandler a handler for the OK button click event
	 * @param cancelHandler a handler for the Cancel button click event
	 * @param animation animates the dialog while showing or hiding the confirm
	 */
	public static Confirm show(String title, String message, OkHandler okHandler, CancelHandler cancelHandler, DialogAnimation animation)
	{
		return show(title, message, WidgetMsgFactory.getMessages().okLabel(), WidgetMsgFactory.getMessages().cancelLabel(), 
				okHandler, cancelHandler, DEFAULT_STYLE_NAMES, animation);
	}

	/**
	 * Shows a confirm dialog
	 * @param title the text to be displayed as the caption of the confirm 
	 * @param message the text to be displayed in the body of the confirm
	 * @param okHandler a handler for the OK button click event
	 * @param cancelHandler a handler for the Cancel button click event
	 * @param movable if true, the window can be dragged
	 * @param resizable if true, the window can be resized
	 * @param animation animates the dialog while showing or hiding the confirm
	 */
	public static Confirm show(String title, String message, OkHandler okHandler, CancelHandler cancelHandler, boolean movable, boolean resizable, DialogAnimation animation)
	{
		return show(title, message, WidgetMsgFactory.getMessages().okLabel(), WidgetMsgFactory.getMessages().cancelLabel(), 
				okHandler, cancelHandler, movable, resizable, DEFAULT_STYLE_NAMES, animation);
	}

	/**
	 * Shows a confirm dialog
	 * @param title the text to be displayed as the caption of the confirm 
	 * @param message the text to be displayed in the body of the confirm
	 * @param okLabel the text to be displayed in the body of the confirm
	 * @param cancelLabel the text to be displayed in the body of the confirm
	 * @param okHandler a handler for the OK button click event
	 * @param cancelHandler a handler for the Cancel button click event
	 */
	public static Confirm show(String title, String message, String okLabel, String cancelLabel, OkHandler okHandler, CancelHandler cancelHandler)
	{
		return show(title, message, okLabel, cancelLabel, okHandler, cancelHandler, DEFAULT_STYLE_NAMES, null);
	}

	/**
	 * Shows a confirm dialog
	 * @param title the text to be displayed as the caption of the confirm 
	 * @param message the text to be displayed in the body of the confirm
	 * @param okLabel the text to be displayed in the body of the confirm
	 * @param cancelLabel the text to be displayed in the body of the confirm
	 * @param okHandler a handler for the OK button click event
	 * @param cancelHandler a handler for the Cancel button click event
	 * @param movable if true, the window can be dragged
	 * @param resizable if true, the window can be resized
	 */
	public static Confirm show(String title, String message, String okLabel, String cancelLabel, OkHandler okHandler, CancelHandler cancelHandler, 
			boolean movable, boolean resizable)
	{
		return show(title, message, okLabel, cancelLabel, okHandler, cancelHandler, movable, resizable, DEFAULT_STYLE_NAMES, null);
	}

	/**
	 * Shows a confirm dialog
	 * @param title the text to be displayed as the caption of the confirm 
	 * @param message the text to be displayed in the body of the confirm
	 * @param okLabel the text to be displayed in the body of the confirm
	 * @param cancelLabel the text to be displayed in the body of the confirm
	 * @param okHandler a handler for the OK button click event
	 * @param cancelHandler a handler for the Cancel button click event
	 * @param movable if true, the window can be dragged
	 * @param resizable if true, the window can be resized
	 * @param styleName the name of the CSS class to be applied in the confirm element 
	 * @param animation animates the dialog while showing or hiding the confirm
	 */
	public static Confirm show(String dialogTitle, String message, String okLabel, String cancelLabel, OkHandler okHandler, 
			CancelHandler cancelHandler, String styleName, DialogAnimation animation)
	{
		return show(dialogTitle, message, okLabel, cancelLabel, okHandler, cancelHandler, true, false, styleName, animation);
	}

	/**
	 * Shows a confirm dialog
	 * @param title the text to be displayed as the caption of the confirm 
	 * @param message the text to be displayed in the body of the confirm
	 * @param okLabel the text to be displayed in the body of the confirm
	 * @param cancelLabel the text to be displayed in the body of the confirm
	 * @param okHandler a handler for the OK button click event
	 * @param cancelHandler a handler for the Cancel button click event
	 * @param movable if true, the window can be dragged
	 * @param resizable if true, the window can be resized
	 * @param styleName the name of the CSS class to be applied in the confirm element 
	 * @param animation animates the dialog while showing or hiding the confirm
	 */
	public static Confirm show(String dialogTitle, String message, String okLabel, String cancelLabel, OkHandler okHandler, 
			CancelHandler cancelHandler, boolean movable, boolean resizable, String styleName, DialogAnimation animation)
	{
		Confirm confirm = new Confirm(movable, resizable, styleName); 
		confirm.setDialogTitle(dialogTitle);
		confirm.setOkLabel(okLabel);
		confirm.setCancelLabel(cancelLabel);
		confirm.setMessage(message);
		confirm.setAnimation(animation);
		if (okHandler != null)
		{
			confirm.addOkHandler(okHandler);
		}
		if (cancelHandler != null)
		{
			confirm.addCancelHandler(cancelHandler);
		}
		confirm.center();
		return confirm;
	}

	@Override
	public void setWidget(IsWidget w)
	{
		throw new UnsupportedOperationException(WidgetMsgFactory.getMessages().canNotAddWidgetOnThisDialog());
	}
	
	@Override
	public void setWidget(Widget w)
	{
		throw new UnsupportedOperationException(WidgetMsgFactory.getMessages().canNotAddWidgetOnThisDialog());
	}

	/**
	 * Sets the message to be shown
	 * @param message the text to be displayed
	 * @param type the message type, used to apply a particular style
	 */
	public void setMessage(SafeHtml message)
	{
		this.msgLabel.setHTML(message);
	}
	
	/**
	 * Sets the message to be shown
	 * @param message the text to be displayed
	 * @param type the message type, used to apply a particular style
	 */
	public void setMessage(String message)
	{
		this.msgLabel.setText(message);
	}
	
	/**
	 * Changes the ok button's text
	 * @param btnText
	 */
	public void setOkLabel(String btnText)
	{
		okButton.setText(btnText);
	}

	/**
	 * Changes the ok button's text
	 * @param btnText
	 */
	public void setCancelLabel(String btnText)
	{
		cancelButton.setText(btnText);
	}

	/**
	 * Adds a handler for the OK button click event
	 */
	public HandlerRegistration addOkHandler(OkHandler handler)
	{
		return addHandler(handler, OkEvent.getType());
	}	

	/**
	 * Adds a handler for the OK button click event
	 */
	public HandlerRegistration addCancelHandler(CancelHandler handler)
	{
		return addHandler(handler, CancelEvent.getType());
	}	

	/**
	 * Creates the message panel to be inserted in confirm
	 * @return
	 */
	private Widget createMessagePanel() 
	{
		FlowPanel contents = new FlowPanel();
		contents.setStyleName("faces-Confirm-content");
		
		msgLabel = new HTML();
		contents.add(msgLabel);
		
		okButton = createOkButton();
		cancelButton = createCancelButton();
		
		okButton.addStyleName("faces--secondary");
		
		NavPanel buttons = new NavPanel();
		buttons.setStyleName("faces-popup-actionPanel");
		
		buttons.add(cancelButton);
		buttons.add(okButton);
		
		contents.add(buttons);

		return contents;
	}

	private Button createOkButton()
    {
		Button okButton = new Button();
		okButton.addSelectHandler(new SelectHandler() 
		{
			@Override
			public void onSelect(SelectEvent event) 
			{
				hide();
				try
				{
					OkEvent.fire(Confirm.this);
				}
				catch (Throwable e)
				{
					Crux.getErrorHandler().handleError(e);
				}
			}
		});
		okButton.setText(WidgetMsgFactory.getMessages().okLabel());
		return okButton;
    }

	private Button createCancelButton()
    {
		Button cancelButton = new Button();
		cancelButton.addSelectHandler(new SelectHandler() 
		{
			@Override
			public void onSelect(SelectEvent event) 
			{
				hide();
				try
				{
					CancelEvent.fire(Confirm.this);
				}
				catch (Throwable e)
				{
					Crux.getErrorHandler().handleError(e);
				}
			}
		});
		cancelButton.setText(WidgetMsgFactory.getMessages().cancelLabel());
		return cancelButton;
    }
}