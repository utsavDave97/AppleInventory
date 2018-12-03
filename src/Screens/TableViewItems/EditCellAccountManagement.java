package Screens.TableViewItems;

import javafx.beans.value.ObservableValue;
import javafx.scene.control.TableCell;
import javafx.scene.control.TextField;

/**
 * /*
 * Copyright (c) 2012, 2013 Oracle and/or its affiliates.
 * All rights reserved. Use is subject to license terms.
 *
 * This file is available and licensed under the following license:
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 *  - Redistributions of source code must retain the above copyright
 *    notice, this list of conditions and the following disclaimer.
 *  - Redistributions in binary form must reproduce the above copyright
 *    notice, this list of conditions and the following disclaimer in
 *    the documentation and/or other materials provided with the distribution.
 *  - Neither the name of Oracle nor the names of its
 *    contributors may be used to endorse or promote products derived
 *    from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
 * LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR
 * A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT
 * OWNER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
 * SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT
 * LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
 * DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
 * THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 *
 * @Description This class mainly for TableFieldCell commit event processing
 * */
public class EditCellAccountManagement extends TableCell<ScreenUser, String>
{
	private TextField textField;

    public EditCellAccountManagement() 
    {
    }

    @Override
    public void startEdit() 
    {
      if (!isEmpty()) 
      {
        super.startEdit();
        createTextField();
        setText(null);
        setGraphic(textField);
        textField.selectAll();
      }
    }

    @Override
    public void cancelEdit() 
    {
      super.cancelEdit();

      setText((String) getItem());
      setGraphic(null);
    }

    @Override
    public void updateItem(String item, boolean empty) 
    {
      super.updateItem(item, empty);

      if (empty) 
      {
        setText(null);
        setGraphic(null);
      } else 
      {
        if (isEditing()) 
        {
          if (textField != null) 
          {
            textField.setText(getString());
          }
          setText(null);
          setGraphic(textField);
        } 
        else 
        {
          setText(getString());
          setGraphic(null);
        }
      }
    }

    private void createTextField() 
    {
      textField = new TextField(getString());
      textField.setMinWidth(this.getWidth() - this.getGraphicTextGap() * 2);
      textField.focusedProperty()
          .addListener(
              (ObservableValue<? extends Boolean> arg0, Boolean arg1,
                  Boolean arg2) -> {
                if (!arg2) {
                  commitEdit(textField.getText());
                }
              });
    }

    private String getString() 
    {
      return getItem() == null ? "" : getItem().toString();
    }
}
