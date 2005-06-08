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
 * $Id: XSDSchemaContentImpl.java,v 1.1.2.1 2005/06/08 18:26:23 nickb Exp $
 */
package org.eclipse.xsd.impl;


import java.util.Collection;

import org.w3c.dom.Element;
import org.w3c.dom.Node;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.xsd.XSDPackage;
import org.eclipse.xsd.XSDSchemaContent;
import org.eclipse.xsd.util.XSDConstants;


/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Schema Content</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public abstract class XSDSchemaContentImpl 
  extends XSDConcreteComponentImpl 
  implements XSDSchemaContent
{
  public static XSDSchemaContent createSchemaContent(Node node)
  {
    switch (XSDConstants.nodeType(node))
    {
      case XSDConstants.ANNOTATION_ELEMENT:
      {
        return XSDAnnotationImpl.createAnnotation(node);
      }
      case XSDConstants.ATTRIBUTE_ELEMENT:
      {
        return XSDAttributeDeclarationImpl.createAttributeDeclaration(node);
      }
      case XSDConstants.ELEMENT_ELEMENT:
      {
        return XSDElementDeclarationImpl.createElementDeclaration(node);
      }
      case XSDConstants.SIMPLETYPE_ELEMENT:
      {
        return XSDSimpleTypeDefinitionImpl.createSimpleTypeDefinition(node);
      }
      case XSDConstants.COMPLEXTYPE_ELEMENT:
      {
        return XSDComplexTypeDefinitionImpl.createComplexTypeDefinition(node);
      }
      case XSDConstants.ATTRIBUTEGROUP_ELEMENT:
      {
        return XSDAttributeGroupDefinitionImpl.createAttributeGroupDefinition(node);
      }
      case XSDConstants.GROUP_ELEMENT:
      {
        return XSDModelGroupDefinitionImpl.createModelGroupDefinition(node);
      }
      case XSDConstants.INCLUDE_ELEMENT:
      {
        return XSDIncludeImpl.createInclude(node);
      }
      case XSDConstants.IMPORT_ELEMENT:
      {
        return XSDImportImpl.createImport(node);
      }
      case XSDConstants.REDEFINE_ELEMENT:
      {
        return XSDRedefineImpl.createRedefine(node);
      }
      case XSDConstants.NOTATION_ELEMENT:
      {
        return XSDNotationDeclarationImpl.createNotationDeclaration(node);
      }
    }

    return null;
  }

  protected XSDSchemaContentImpl() 
  {
    super();
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected EClass eStaticClass()
  {
    return XSDPackage.eINSTANCE.getXSDSchemaContent();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, Class baseClass, NotificationChain msgs)
  {
    if (featureID >= 0)
    {
      switch (eDerivedStructuralFeatureID(featureID, baseClass))
      {
        case XSDPackage.XSD_SCHEMA_CONTENT__DIAGNOSTICS:
          return ((InternalEList)getDiagnostics()).basicRemove(otherEnd, msgs);
        default:
          return eDynamicInverseRemove(otherEnd, featureID, baseClass, msgs);
      }
    }
    return eBasicSetContainer(null, featureID, msgs);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Object eGet(EStructuralFeature eFeature, boolean resolve)
  {
    switch (eDerivedStructuralFeatureID(eFeature))
    {
      case XSDPackage.XSD_SCHEMA_CONTENT__ELEMENT:
        return getElement();
      case XSDPackage.XSD_SCHEMA_CONTENT__CONTAINER:
        return getContainer();
      case XSDPackage.XSD_SCHEMA_CONTENT__ROOT_CONTAINER:
        return getRootContainer();
      case XSDPackage.XSD_SCHEMA_CONTENT__SCHEMA:
        return getSchema();
      case XSDPackage.XSD_SCHEMA_CONTENT__DIAGNOSTICS:
        return getDiagnostics();
    }
    return eDynamicGet(eFeature, resolve);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void eSet(EStructuralFeature eFeature, Object newValue)
  {
    switch (eDerivedStructuralFeatureID(eFeature))
    {
      case XSDPackage.XSD_SCHEMA_CONTENT__ELEMENT:
        setElement((Element)newValue);
        return;
      case XSDPackage.XSD_SCHEMA_CONTENT__DIAGNOSTICS:
        getDiagnostics().clear();
        getDiagnostics().addAll((Collection)newValue);
        return;
    }
    eDynamicSet(eFeature, newValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void eUnset(EStructuralFeature eFeature)
  {
    switch (eDerivedStructuralFeatureID(eFeature))
    {
      case XSDPackage.XSD_SCHEMA_CONTENT__ELEMENT:
        setElement(ELEMENT_EDEFAULT);
        return;
      case XSDPackage.XSD_SCHEMA_CONTENT__DIAGNOSTICS:
        getDiagnostics().clear();
        return;
    }
    eDynamicUnset(eFeature);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean eIsSet(EStructuralFeature eFeature)
  {
    switch (eDerivedStructuralFeatureID(eFeature))
    {
      case XSDPackage.XSD_SCHEMA_CONTENT__ELEMENT:
        return ELEMENT_EDEFAULT == null ? element != null : !ELEMENT_EDEFAULT.equals(element);
      case XSDPackage.XSD_SCHEMA_CONTENT__CONTAINER:
        return getContainer() != null;
      case XSDPackage.XSD_SCHEMA_CONTENT__ROOT_CONTAINER:
        return getRootContainer() != null;
      case XSDPackage.XSD_SCHEMA_CONTENT__SCHEMA:
        return getSchema() != null;
      case XSDPackage.XSD_SCHEMA_CONTENT__DIAGNOSTICS:
        return diagnostics != null && !diagnostics.isEmpty();
    }
    return eDynamicIsSet(eFeature);
  }

} 
