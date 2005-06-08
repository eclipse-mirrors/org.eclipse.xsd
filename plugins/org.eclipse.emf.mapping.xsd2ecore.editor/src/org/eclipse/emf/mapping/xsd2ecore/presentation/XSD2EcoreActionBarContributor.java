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
 * $Id: XSD2EcoreActionBarContributor.java,v 1.1.2.1 2005/06/08 18:26:24 nickb Exp $
 */
package org.eclipse.emf.mapping.xsd2ecore.presentation;


import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.action.Separator;

import org.eclipse.emf.edit.ui.action.EditingDomainActionBarContributor;


/**
 * This is the action bar contributor for the XSD2Ecore model editor.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class XSD2EcoreActionBarContributor
  extends EditingDomainActionBarContributor
{
  /**
   * This creates an instance of the contributor.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public XSD2EcoreActionBarContributor()
  {
  }

  /**
   * This adds Separators for editor additions to the tool bar.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void contributeToToolBar(IToolBarManager toolBarManager)
  {
    toolBarManager.add(new Separator("xsd2ecore-settings"));
    toolBarManager.add(new Separator("xsd2ecore-additions"));
  }
}
