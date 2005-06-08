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
 * $Id: XSD2EcoreFactory.java,v 1.1.2.1 2005/06/08 18:26:24 nickb Exp $
 */
package org.eclipse.emf.mapping.xsd2ecore;


import org.eclipse.emf.ecore.EFactory;


/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.emf.mapping.xsd2ecore.XSD2EcorePackage
 * @generated
 */
public interface XSD2EcoreFactory extends EFactory {
  /**
   * The singleton instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  XSD2EcoreFactory eINSTANCE = new org.eclipse.emf.mapping.xsd2ecore.impl.XSD2EcoreFactoryImpl();

  /**
   * Returns a new object of class '<em>Mapping Root</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Mapping Root</em>'.
   * @generated
   */
  XSD2EcoreMappingRoot createXSD2EcoreMappingRoot();

  /**
   * Returns the package supported by this factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the package supported by this factory.
   * @generated
   */
  XSD2EcorePackage getXSD2EcorePackage();

} //XSD2EcoreFactory
