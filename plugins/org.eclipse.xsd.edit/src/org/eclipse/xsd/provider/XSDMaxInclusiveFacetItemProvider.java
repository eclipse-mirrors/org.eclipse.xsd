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
 * $Id: XSDMaxInclusiveFacetItemProvider.java,v 1.1.2.1 2005/06/08 18:26:23 nickb Exp $
 */
package org.eclipse.xsd.provider;


import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;

import org.eclipse.xsd.XSDMaxInclusiveFacet;


/**
 * This is the item provider adpater for a {@link org.eclipse.xsd.XSDMaxInclusiveFacet} object.
 */
public class XSDMaxInclusiveFacetItemProvider
  extends XSDMaxFacetItemProvider
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
  public XSDMaxInclusiveFacetItemProvider(AdapterFactory adapterFactory)
  {
    super(adapterFactory);
  }

  /**
   * This returns the property descriptors for the adapted class.
   */
  public List getPropertyDescriptors(Object object)
  {
    if (itemPropertyDescriptors == null)
    {
      super.getPropertyDescriptors(object);

      XSDMaxInclusiveFacet xsdMaxInclusiveFacet = ((XSDMaxInclusiveFacet)object);

      // This is for the value feature.
      //
      itemPropertyDescriptors.add
        (new ItemPropertyDescriptor
          (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
           XSDEditPlugin.getString("_UI_Value_label"),
           XSDEditPlugin.getString("_UI_ValueMaxInclusiveFacet_description"),
           xsdPackage.getXSDMaxFacet_Value(),
           true,
           ItemPropertyDescriptor.TEXT_VALUE_IMAGE));

    }
    return itemPropertyDescriptors;
  }

  /**
   * This returns XSDMaxInclusiveFacet.gif.
   */
  public Object getImage(Object object)
  {
    return XSDEditPlugin.getImage("full/obj16/XSDMaxInclusiveFacet");
  }
}
