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
 * $Id: XSDMaxFacetItemProvider.java,v 1.1.2.1 2005/06/08 18:26:23 nickb Exp $
 */
package org.eclipse.xsd.provider;


import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;

import org.eclipse.xsd.XSDMaxFacet;


/**
 * This is the item provider adpater for a {@link org.eclipse.xsd.XSDMaxFacet} object.
 */
public class XSDMaxFacetItemProvider
  extends XSDFixedFacetItemProvider
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
  public XSDMaxFacetItemProvider(AdapterFactory adapterFactory)
  {
    super(adapterFactory);
  }

  public String getText(Object object)
  {
    XSDMaxFacet xsdMaxFacet = (XSDMaxFacet)object;
    String result = xsdMaxFacet.getLexicalValue();
    return result == null ? "" : result;
  }

  /**
   * This handles notification by calling {@link #fireNotifyChanged fireNotifyChanged}.
   */
  public void notifyChanged(Notification msg) 
  {
    if (msg.getFeature() == xsdPackage.getXSDMaxFacet_Value())
    {
      fireNotifyChanged(msg);
    }
    else
    {
      super.notifyChanged(msg);
    }
  }
}
