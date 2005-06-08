/**
 * <copyright>
 *
 * Copyright (c) 2002-2004 IBM Corporation and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: 
 *   IBM - Initial API and implementation
 *
 * </copyright>
 *
 * $Id: XSDParticleItemProvider.java,v 1.2.2.1 2005/06/08 18:26:23 nickb Exp $
 */
package org.eclipse.xsd.provider;


import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CommandWrapper;
import org.eclipse.emf.common.command.UnexecutableCommand;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.edit.command.CommandParameter;
import org.eclipse.emf.edit.command.CreateChildCommand;
import org.eclipse.emf.edit.command.RemoveCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.ComposedImage;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptorDecorator;

import org.eclipse.xsd.XSDParticle;
import org.eclipse.xsd.XSDParticleContent;


/**
 * This is the item provider adpater for a {@link org.eclipse.xsd.XSDParticle} object.
 */
public class XSDParticleItemProvider
  extends XSDComplexTypeContentItemProvider
  implements 
    IEditingDomainItemProvider,
    IStructuredItemContentProvider, 
    ITreeItemContentProvider, 
    IItemLabelProvider, 
    IItemPropertySource
{
  /**
   * This constructs an instance from a factory and a notifier.
   */
  public XSDParticleItemProvider(AdapterFactory adapterFactory)
  {
    super(adapterFactory);
  }

  protected XSDParticleContent getDelegate(XSDParticle xsdParticle)
  {
    return xsdParticle.getContent();
  }

  /**
   * This returns the property descriptors for the adapted class.
   */
  public List getPropertyDescriptors(Object object)
  {
    itemPropertyDescriptors = null;
    super.getPropertyDescriptors(object);

    XSDParticle xsdParticle = (XSDParticle)object;
    XSDParticleContent xsdParticleContent = getDelegate(xsdParticle);
    if (xsdParticleContent != null)
    {
      for (Iterator delegatedPropertyDescriptors = itemDelegator.getPropertyDescriptors(xsdParticleContent).iterator();
           delegatedPropertyDescriptors.hasNext(); )
      {
        IItemPropertyDescriptor delegatedItemPropertyDescriptor = (IItemPropertyDescriptor)delegatedPropertyDescriptors.next();
        itemPropertyDescriptors.add(new ItemPropertyDescriptorDecorator(xsdParticleContent, delegatedItemPropertyDescriptor));
      }
    }


    // This is for the minOccurs feature.
    //
    itemPropertyDescriptors.add
      (new ItemPropertyDescriptor
        (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
         XSDEditPlugin.getString("_UI_MinOccurs_label"),
         XSDEditPlugin.getString("_UI_MinOccurs_description"),
         xsdPackage.getXSDParticle_MinOccurs(),
         true,
         ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE));

    // This is for the maxOccurs feature.
    //
    itemPropertyDescriptors.add
      (new ItemPropertyDescriptor
        (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
         XSDEditPlugin.getString("_UI_MaxOccurs_label"),
         XSDEditPlugin.getString("_UI_MaxOccurs_description"),
         xsdPackage.getXSDParticle_MaxOccurs(),
         true,
         ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE));

    return itemPropertyDescriptors;
  }

  /**
   * This specifies how to implement {@link #getChildren} and is used to deduce an appropriate feature for an
   * {@link org.eclipse.emf.edit.command.AddCommand}, {@link org.eclipse.emf.edit.command.RemoveCommand} or
   * {@link org.eclipse.emf.edit.command.MoveCommand} in {@link #createCommand}.
   */
  public Collection getChildrenFeatures(Object object)
  {
    if (childrenFeatures == null)
    {
      super.getChildrenFeatures(object);
      childrenFeatures.clear();
/*
      XSDParticle xsdParticle = ((XSDParticle)object);
      childrenFeatures.add(xsdPackage.getXSDParticle_Content());
*/
    }
    return childrenFeatures;
  }

  public Collection getChildren(Object object)
  {
    XSDParticle xsdParticle = (XSDParticle)object;
    XSDParticleContent xsdParticleContent = getDelegate(xsdParticle);
    if (xsdParticleContent != null)
    {
      return itemDelegator.getChildren(xsdParticleContent);
    }
    else
    {
      return Collections.EMPTY_LIST;
    }
  }

  public boolean hasChildren(Object object)
  {
    XSDParticle xsdParticle = (XSDParticle)object;
    XSDParticleContent xsdParticleContent = getDelegate(xsdParticle);
    return 
      xsdParticleContent != null && itemDelegator.hasChildren(xsdParticleContent);
  }

  /**
   * This returns XSDParticle.gif.
   */
  public Object getImage(Object object)
  {
    XSDParticle xsdParticle = ((XSDParticle)object);
    XSDParticleContent xsdParticleContent = getDelegate(xsdParticle);
    if (xsdParticleContent != null)
    {
      Collection images = new ArrayList();
      images.add(itemDelegator.getImage(xsdParticleContent));
      String imageName = "full/obj16/XSDOccurrence";
      int minOccurs = xsdParticle.getMinOccurs();
      int maxOccurs = xsdParticle.getMaxOccurs();
      if (minOccurs >= 0 && (minOccurs <= maxOccurs || maxOccurs == -1))
      {
        switch (minOccurs)
        {
          case 0:
          {
            imageName += "Zero";
            break;
          }
          case 1:
          {
            imageName += "One";
            break;
          }
          default:
          {
            imageName += "N";
            break;
          }
        }
  
        if (minOccurs != maxOccurs)
        {
          switch (maxOccurs)
          {
            case -1:
            {
              imageName += "ToUnbounded";
              break;
            }
            case 0:
            {
              break;
            }
            case 1:
            {
              imageName += "ToOne";
              break;
            }
            default:
            {
              imageName += xsdParticle.getMinOccurs() <= 1 ? "ToN" : "ToM";
              break;
            }
          }
        }
      }
      else
      {
        imageName += "NToM";
      }
  
      if (!imageName.equals("full/obj16/XSDOccurrenceOne"))
      {
        images.add(XSDEditPlugin.getImage(imageName));
      }
 
      return new ComposedImage(images);
    }
    else
    {
      return XSDEditPlugin.getImage("full/obj16/XSDParticle");
    }
  }

  public String getText(Object object)
  {
    XSDParticle xsdParticle = ((XSDParticle)object);
    XSDParticleContent xsdParticleContent = getDelegate(xsdParticle);
    if (xsdParticleContent != null)
    {
      return itemDelegator.getText(xsdParticleContent);
    }
    else
    {
      return
        xsdParticle.getMinOccurs() +
        ".." +
        (xsdParticle.getMaxOccurs() == -1 ? "unbounded" : Integer.toString(xsdParticle.getMaxOccurs()));
    }
  }

  /**
   * This handles notification by calling {@link #fireNotifyChanged fireNotifyChanged}.
   */
  public void notifyChanged(Notification msg) 
  {
    XSDParticle xsdParticle = (XSDParticle)msg.getNotifier();
    if (
         msg.getFeature() == xsdPackage.getXSDParticle_MinOccurs() || 
         msg.getFeature() == xsdPackage.getXSDParticle_MaxOccurs() || 
         msg.getFeature() == xsdPackage.getXSDParticle_Content() || 
         msg.getFeature() == xsdPackage.getXSDParticle_Term()
       )
    {
      fireNotifyChanged(msg);
      return;
    }
    super.notifyChanged(msg);
  }

  /**
   * This returns a list of child descriptors based on the particle content,
   * not the particle itself.
   */
  public Collection getNewChildDescriptors(Object object, EditingDomain domain, Object sibling)
  {
    Object content = ((XSDParticle) object).getContent();
    return domain.getNewChildDescriptors(content, sibling);
  }

  /**
   * This returns Remove and CreateChild commands (at least) that are based
   * on the attributeUse content, not the attributeUse itself.
   */
  public Command createCommand(final Object object, final EditingDomain domain, Class commandClass, CommandParameter commandParameter)
  {
    if (commandClass == RemoveCommand.class ||
        commandClass == CreateChildCommand.class)
    {
      Object owner = ((XSDParticle) object).getContent();
      if (owner == null)
      {
        return UnexecutableCommand.INSTANCE;
      }

      commandParameter.setOwner(owner);

      // RemoveCommand requires a wrapper that returns the correct affected
      // object after an execute or redo (the particle or attribute use
      // itself, instead of its content)
      if (commandClass == RemoveCommand.class)
      {
        return new CommandWrapper(
          domain.createCommand(commandClass, commandParameter))
        {
          private Collection affectedObjects = Collections.EMPTY_SET;

          public void execute()
          {
            super.execute();
            affectedObjects = (object == null ) ?
              Collections.EMPTY_SET : Collections.singleton(object);
          }
            
          public void undo()
          {
            super.undo();
            affectedObjects = super.getAffectedObjects();
          }

          public void redo()
          {
            super.redo();
            affectedObjects = (object == null ) ?
              Collections.EMPTY_SET : Collections.singleton(object);
          }

          public Collection getAffectedObjects()
          {
            return affectedObjects;
          }
        };
      }

      // CreateChildCommand handles its affected objects correctly
      return domain.createCommand(commandClass, commandParameter);
    }
    return super.createCommand(object, domain, commandClass, commandParameter);
  }

/*
  protected Command factorRemoveCommand(EditingDomain domain, CommandParameter commandParameter)
  {
    XSDParticle xsdParticle = (XSDParticle)commandParameter.getRefOwner();
    return 
      domain.createCommand
        (RemoveCommand.class,
         new CommandParameter
           (getDelegate(xsdParticle),
            commandParameter.getFeature(),
            commandParameter.getCollection(),
            commandParameter.getIndex()));
  }

  protected Command factorAddCommand(EditingDomain domain, CommandParameter commandParameter)
  {
    XSDParticle xsdParticle = (XSDParticle)commandParameter.getRefOwner();
    return 
      domain.createCommand
        (AddCommand.class,
         new CommandParameter
           (getDelegate(xsdParticle),
            commandParameter.getFeature(),
            commandParameter.getCollection(),
            commandParameter.getIndex()));
  }

  protected Command factorMoveCommand(EditingDomain domain, CommandParameter commandParameter)
  {
    XSDParticle xsdParticle = (XSDParticle)commandParameter.getRefOwner();
    return 
      domain.createCommand
        (MoveCommand.class,
         new CommandParameter
           (getDelegate(xsdParticle),
            commandParameter.getFeature(),
            commandParameter.getValue(),
            commandParameter.getIndex()));
  }
*/
}
