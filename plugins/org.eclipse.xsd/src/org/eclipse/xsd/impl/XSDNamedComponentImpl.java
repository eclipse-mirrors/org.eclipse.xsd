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
 * $Id: XSDNamedComponentImpl.java,v 1.3.2.1 2005/06/08 18:26:23 nickb Exp $
 */
package org.eclipse.xsd.impl;


import java.text.Collator;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import org.w3c.dom.Element;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.xsd.XSDComplexTypeDefinition;
import org.eclipse.xsd.XSDConcreteComponent;
import org.eclipse.xsd.XSDNamedComponent;
import org.eclipse.xsd.XSDPackage;
import org.eclipse.xsd.XSDSchema;
import org.eclipse.xsd.XSDSimpleTypeDefinition;
import org.eclipse.xsd.XSDVariety;
import org.eclipse.xsd.util.XSDConstants;


/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Named Component</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.xsd.impl.XSDNamedComponentImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.xsd.impl.XSDNamedComponentImpl#getTargetNamespace <em>Target Namespace</em>}</li>
 *   <li>{@link org.eclipse.xsd.impl.XSDNamedComponentImpl#getAliasName <em>Alias Name</em>}</li>
 *   <li>{@link org.eclipse.xsd.impl.XSDNamedComponentImpl#getURI <em>URI</em>}</li>
 *   <li>{@link org.eclipse.xsd.impl.XSDNamedComponentImpl#getAliasURI <em>Alias URI</em>}</li>
 *   <li>{@link org.eclipse.xsd.impl.XSDNamedComponentImpl#getQName <em>QName</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class XSDNamedComponentImpl 
  extends XSDComponentImpl 
  implements XSDNamedComponent
{
  /**
   * The default value of the '{@link #getName() <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getName()
   * @generated
   * @ordered
   */
  protected static final String NAME_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getName()
   * @generated
   * @ordered
   */
  protected String name = NAME_EDEFAULT;

  /**
   * The default value of the '{@link #getTargetNamespace() <em>Target Namespace</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTargetNamespace()
   * @generated
   * @ordered
   */
  protected static final String TARGET_NAMESPACE_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getTargetNamespace() <em>Target Namespace</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTargetNamespace()
   * @generated
   * @ordered
   */
  protected String targetNamespace = TARGET_NAMESPACE_EDEFAULT;

  /**
   * The default value of the '{@link #getAliasName() <em>Alias Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAliasName()
   * @generated
   * @ordered
   */
  protected static final String ALIAS_NAME_EDEFAULT = null;

  /**
   * The default value of the '{@link #getURI() <em>URI</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getURI()
   * @generated
   * @ordered
   */
  protected static final String URI_EDEFAULT = null;

  /**
   * The default value of the '{@link #getAliasURI() <em>Alias URI</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAliasURI()
   * @generated
   * @ordered
   */
  protected static final String ALIAS_URI_EDEFAULT = null;

  /**
   * The default value of the '{@link #getQName() <em>QName</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getQName()
   * @generated
   * @ordered
   */
  protected static final String QNAME_EDEFAULT = null;

  public static List sortNamedComponents(Collection xsdNamedComponents)
  {
    Object [] objects = xsdNamedComponents.toArray();
    Arrays.sort(objects, Comparator.getInstance());

    return Arrays.asList(objects);
  }

  public static void addToSortedList(List xsdNamedComponents, XSDNamedComponent xsdNamedComponent)
  {
    int index = Collections.binarySearch(xsdNamedComponents, xsdNamedComponent, Comparator.getInstance());
    if (index < 0)
    {
      xsdNamedComponents.add(-(index + 1), xsdNamedComponent);
    }
    else if (xsdNamedComponents.get(index) != xsdNamedComponent)
    {
      xsdNamedComponents.add(index, xsdNamedComponent);
    }
  }

  public static XSDNamedComponent findInSortedList(List xsdNamedComponents, String targetNamespace, String localName)
  {
    int index = 
      Collections.binarySearch(xsdNamedComponents, new String [] { targetNamespace, localName}, StringPairComparator.getInstance());
    if (index < 0)
    {
      return null;
    }
    else 
    {
      return (XSDNamedComponent)xsdNamedComponents.get(index);
    }
  }

  public static void mergeToSortedList(List xsdNamedComponentsTarget, List xsdNamedComponentsSource)
  {
    Iterator sourceComponents = xsdNamedComponentsSource.iterator();
    if (sourceComponents.hasNext())
    {
      Comparator comparator = Comparator.getInstance();
      Object sourceComponent = sourceComponents.next();
      for (ListIterator targetComponents = xsdNamedComponentsTarget.listIterator(); targetComponents.hasNext(); )
      {
        Object targetComponent = targetComponents.next();
        if (targetComponent == sourceComponent)
        {
        }
        else if (comparator.compare(sourceComponent, targetComponent) < 0)
        {
          targetComponents.previous();
          targetComponents.add(sourceComponent);
        }
        else
        {
          continue;
        }

        if (sourceComponents.hasNext())
        {
          sourceComponent = sourceComponents.next();
        }
        else
        {
          sourceComponent = null;
          break;
        }
      }

      if (sourceComponent != null)
      {
        xsdNamedComponentsTarget.add(sourceComponent);
        while (sourceComponents.hasNext())
        {
          sourceComponent = sourceComponents.next();
          xsdNamedComponentsTarget.add(sourceComponent);
        }
      }
    }
  }

  public static class Comparator implements java.util.Comparator
  {
    protected static Comparator instance = new Comparator();

    public static Comparator getInstance()
    {
      if (instance == null)
      {
         instance = new Comparator();
      }
      return instance;
    }

    protected Collator collator = Collator.getInstance();
  
    public Comparator()
    {
    }
  
    public boolean equals(Object that)
    {
      return this == that;
    }
  
    public int compare(Object o1, Object o2)
    {
      XSDNamedComponent xsdNamedComponent1 = (XSDNamedComponent)o1;
      XSDNamedComponent xsdNamedComponent2 = (XSDNamedComponent)o2;
      String name1 = xsdNamedComponent1.getName();
      String name2 = xsdNamedComponent2.getName();
      if (name1 == null && name2 == null)
      {
        return xsdNamedComponent1.hashCode() - xsdNamedComponent2.hashCode();
      }
      else if (name1 == null)
      {
        return 1;
      }
      else if (name2 == null)
      {
        return -1;
      }
      else
      {
        int result = collator.compare(name1, name2);
        if (result == 0)
        {
          String namespace1 = xsdNamedComponent1.getTargetNamespace();
          String namespace2 = xsdNamedComponent2.getTargetNamespace();
          if (namespace1 == null && namespace2 == null)
          {
            return xsdNamedComponent1.hashCode() - xsdNamedComponent2.hashCode();
          }
          else if (namespace1 == null)
          {
            return 1;
          }
          else if (namespace2 == null)
          {
            return -1;
          }
          else
          {
            result = collator.compare(namespace1, namespace2);
            if (result == 0)
            {
              result = xsdNamedComponent1.hashCode() - xsdNamedComponent2.hashCode();
            }
            return result;
          }
        }
        else
        {
          return result;
        }
      }
    }
  }

  public static class StringPairComparator implements java.util.Comparator
  {
    protected static StringPairComparator instance = new StringPairComparator();

    public static StringPairComparator getInstance()
    {
      if (instance == null)
      {
         instance = new StringPairComparator();
      }
      return instance;
    }

    protected Collator collator = Collator.getInstance();
  
    public StringPairComparator()
    {
    }
  
    public boolean equals(Object that)
    {
      return this == that;
    }
  
    public int compare(Object o1, Object o2)
    {
      XSDNamedComponent xsdNamedComponent = (XSDNamedComponent)o1;
      String [] strings = (String [])o2;
      String name1 = xsdNamedComponent.getName();
      String name2 = strings[1];
      if (name1 == null && name2 == null)
      {
        return 0;
      }
      else if (name1 == null)
      {
        return 1;
      }
      else if (name2 == null)
      {
        return -1;
      }
      else
      {
        int result = collator.compare(name1, name2);
        if (result == 0)
        {
          String namespace1 = xsdNamedComponent.getTargetNamespace();
          String namespace2 = strings[0];
          if (namespace1 == null && namespace2 == null)
          {
            return 0;
          }
          else if (namespace1 == null)
          {
            return 1;
          }
          else if (namespace2 == null)
          {
            return -1;
          }
          else
          {
            return collator.compare(namespace1, namespace2);
          }
        }
        else
        {
          return result;
        }
      }
    }
  }

  protected XSDNamedComponentImpl() 
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
    return XSDPackage.eINSTANCE.getXSDNamedComponent();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getName()
  {
    return name;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setName(String newName)
  {
    String oldName = name;
    name = newName;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, XSDPackage.XSD_NAMED_COMPONENT__NAME, oldName, name));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getTargetNamespace()
  {
    return targetNamespace;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setTargetNamespace(String newTargetNamespace)
  {
    String oldTargetNamespace = targetNamespace;
    targetNamespace = newTargetNamespace;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, XSDPackage.XSD_NAMED_COMPONENT__TARGET_NAMESPACE, oldTargetNamespace, targetNamespace));
  }

  protected String getURIReferenceLabel()
  {
    return getName();
  }

  public String getAliasName()
  {
    String result = getName();
    if (result == null)
    {
      XSDConcreteComponent container = getContainer(); 
      if (container instanceof XSDNamedComponent)
      {
        XSDNamedComponent xsdNamedComponent = (XSDNamedComponent)container;
        String baseName = xsdNamedComponent.getAliasName();
        if (container instanceof XSDSimpleTypeDefinition)
        {
          XSDSimpleTypeDefinition xsdSimpleTypeDefinition = (XSDSimpleTypeDefinition)container;
          switch (xsdSimpleTypeDefinition.getVariety().getValue())
          {
            case XSDVariety.ATOMIC:
            {
              result = baseName + "_._base";
              break;
            }
            case XSDVariety.LIST:
            {
              result = baseName + (XSDConstants.isURType(xsdSimpleTypeDefinition.getBaseTypeDefinition()) ? "_._item" : "_._base");
              break;
            }
            case XSDVariety.UNION:
            {
              result = 
                baseName + 
                  (XSDConstants.isURType(xsdSimpleTypeDefinition.getBaseTypeDefinition()) ? 
                     "_._member"  + "_._" + xsdSimpleTypeDefinition.getMemberTypeDefinitions().indexOf(this) :
                     "_._base");
              break;
            }
          }
        }
        else if (container instanceof XSDComplexTypeDefinition)
        {
          result = baseName + "_._base";
        }
        else 
        {
          result = baseName + "_._type";
        }
      }
    }
    return result;
  }

  public String getURI()
  {
    String theTargetNamespace = getTargetNamespace();
    if (theTargetNamespace == null)
    {
      theTargetNamespace = "";
    }
    String theName = getName();
    if (theName == null)
    {
      theName = getAliasName();
    }
    return theTargetNamespace + "#" + theName;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated modifiable
   */
  public String getAliasURI() 
  {
    XSDSchema xsdSchema = getSchema();
    String theTargetNamespace = xsdSchema == null ? getTargetNamespace() : xsdSchema.getTargetNamespace();
    if (theTargetNamespace == null)
    {
      theTargetNamespace = "";
    }
    String theName = getAliasName();
    if (theName == null)
    {
      theName = getAliasName();
    }
    return theTargetNamespace + "#" + theName;
  }

  public String getQName(XSDConcreteComponent relativeToComponent)
  {
    String theName = getName();
    if (theName != null && relativeToComponent != null)
    {
      Element theElement = relativeToComponent.getElement();
      if (theElement != null)
      {
        String qualifier = XSDConstants.lookupQualifier(theElement, getTargetNamespace());
        if (qualifier != null && qualifier.length() != 0)
        {
          return qualifier + ":" + theName;
        }
      }
    }

    return theName;
  }

  public String getQName()
  {
    return getQName(this);
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
        case XSDPackage.XSD_NAMED_COMPONENT__DIAGNOSTICS:
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
      case XSDPackage.XSD_NAMED_COMPONENT__ELEMENT:
        return getElement();
      case XSDPackage.XSD_NAMED_COMPONENT__CONTAINER:
        return getContainer();
      case XSDPackage.XSD_NAMED_COMPONENT__ROOT_CONTAINER:
        return getRootContainer();
      case XSDPackage.XSD_NAMED_COMPONENT__SCHEMA:
        return getSchema();
      case XSDPackage.XSD_NAMED_COMPONENT__DIAGNOSTICS:
        return getDiagnostics();
      case XSDPackage.XSD_NAMED_COMPONENT__NAME:
        return getName();
      case XSDPackage.XSD_NAMED_COMPONENT__TARGET_NAMESPACE:
        return getTargetNamespace();
      case XSDPackage.XSD_NAMED_COMPONENT__ALIAS_NAME:
        return getAliasName();
      case XSDPackage.XSD_NAMED_COMPONENT__URI:
        return getURI();
      case XSDPackage.XSD_NAMED_COMPONENT__ALIAS_URI:
        return getAliasURI();
      case XSDPackage.XSD_NAMED_COMPONENT__QNAME:
        return getQName();
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
      case XSDPackage.XSD_NAMED_COMPONENT__ELEMENT:
        setElement((Element)newValue);
        return;
      case XSDPackage.XSD_NAMED_COMPONENT__DIAGNOSTICS:
        getDiagnostics().clear();
        getDiagnostics().addAll((Collection)newValue);
        return;
      case XSDPackage.XSD_NAMED_COMPONENT__NAME:
        setName((String)newValue);
        return;
      case XSDPackage.XSD_NAMED_COMPONENT__TARGET_NAMESPACE:
        setTargetNamespace((String)newValue);
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
      case XSDPackage.XSD_NAMED_COMPONENT__ELEMENT:
        setElement(ELEMENT_EDEFAULT);
        return;
      case XSDPackage.XSD_NAMED_COMPONENT__DIAGNOSTICS:
        getDiagnostics().clear();
        return;
      case XSDPackage.XSD_NAMED_COMPONENT__NAME:
        setName(NAME_EDEFAULT);
        return;
      case XSDPackage.XSD_NAMED_COMPONENT__TARGET_NAMESPACE:
        setTargetNamespace(TARGET_NAMESPACE_EDEFAULT);
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
      case XSDPackage.XSD_NAMED_COMPONENT__ELEMENT:
        return ELEMENT_EDEFAULT == null ? element != null : !ELEMENT_EDEFAULT.equals(element);
      case XSDPackage.XSD_NAMED_COMPONENT__CONTAINER:
        return getContainer() != null;
      case XSDPackage.XSD_NAMED_COMPONENT__ROOT_CONTAINER:
        return getRootContainer() != null;
      case XSDPackage.XSD_NAMED_COMPONENT__SCHEMA:
        return getSchema() != null;
      case XSDPackage.XSD_NAMED_COMPONENT__DIAGNOSTICS:
        return diagnostics != null && !diagnostics.isEmpty();
      case XSDPackage.XSD_NAMED_COMPONENT__NAME:
        return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
      case XSDPackage.XSD_NAMED_COMPONENT__TARGET_NAMESPACE:
        return TARGET_NAMESPACE_EDEFAULT == null ? targetNamespace != null : !TARGET_NAMESPACE_EDEFAULT.equals(targetNamespace);
      case XSDPackage.XSD_NAMED_COMPONENT__ALIAS_NAME:
        return ALIAS_NAME_EDEFAULT == null ? getAliasName() != null : !ALIAS_NAME_EDEFAULT.equals(getAliasName());
      case XSDPackage.XSD_NAMED_COMPONENT__URI:
        return URI_EDEFAULT == null ? getURI() != null : !URI_EDEFAULT.equals(getURI());
      case XSDPackage.XSD_NAMED_COMPONENT__ALIAS_URI:
        return ALIAS_URI_EDEFAULT == null ? getAliasURI() != null : !ALIAS_URI_EDEFAULT.equals(getAliasURI());
      case XSDPackage.XSD_NAMED_COMPONENT__QNAME:
        return QNAME_EDEFAULT == null ? getQName() != null : !QNAME_EDEFAULT.equals(getQName());
    }
    return eDynamicIsSet(eFeature);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String toString()
  {
    if (eIsProxy()) return super.toString();

    StringBuffer result = new StringBuffer(super.toString());
    result.append(" (name: ");
    result.append(name);
    result.append(", targetNamespace: ");
    result.append(targetNamespace);
    result.append(')');
    return result.toString();
  }

  protected void patch()
  {
    patchTargetNamespaceAttribute();
    super.patch();
  }

  protected void patchTargetNamespaceAttribute()
  {
    XSDSchema xsdSchema = getSchema();
    if (xsdSchema != null)
    {
      String newTargetNamespace = xsdSchema.getTargetNamespace();
      if (newTargetNamespace == null ? getTargetNamespace() != null : !newTargetNamespace.equals(getTargetNamespace()))
      {
        setTargetNamespace(newTargetNamespace);
      }
    }
  }

  protected void adoptBy(XSDSchema xsdSchema)
  {
    String newTargetNamespace = xsdSchema.getTargetNamespace();
    if (newTargetNamespace == null ? getTargetNamespace() != null : !newTargetNamespace.equals(getTargetNamespace()))
    {
      setTargetNamespace(newTargetNamespace);
    }

    super.adoptBy(xsdSchema);
  }

  protected void reconcileAttributes(Element changedElement)
  {
    super.reconcileAttributes(changedElement);
    if (changedElement == getElement())
    {
      reconcileNameAttribute();
    }
  }

  protected void reconcileNameAttribute()
  {
    Element theElement = getElement();
    if (theElement.hasAttributeNS(null, XSDConstants.NAME_ATTRIBUTE))
    {
      String newName = theElement.getAttributeNS(null, XSDConstants.NAME_ATTRIBUTE);
      if (!newName.equals(getName()))
      {
        setName(newName);
      }
    }
    else if (getName() != null)
    {
      setName(null);
    }
  }

  protected void changeAttribute(EAttribute eAttribute)
  {
    super.changeAttribute(eAttribute);
    if (!isNamedComponentReference())
    {
      if (eAttribute == null || eAttribute == XSDPackage.eINSTANCE.getXSDNamedComponent_Name())
      {
        if (eAttribute != null)
        {
          XSDSchemaImpl xsdSchema = (XSDSchemaImpl)getSchema();
          if (xsdSchema != null)
          {
            xsdSchema.updateSortedList(this);
          }
        }

        Element theElement = getElement();
        if (theElement != null)
        {
          niceSetAttribute(theElement, XSDConstants.NAME_ATTRIBUTE, getName());
        }
        if (eAttribute != null)
        {
          traverseToRootForPatching();
        }
      }
    }
  }

  public boolean isNamedComponentReference()
  {
    return false;
  }

  public XSDNamedComponent getResolvedNamedComponent()
  {
    return this;
  }

  public boolean hasSameNameAndTargetNamespace(XSDNamedComponent xsdNamedComponent)
  {
    return 
      (getTargetNamespace() == null ?  
         xsdNamedComponent.getTargetNamespace() == null : 
         getTargetNamespace().equals(xsdNamedComponent.getTargetNamespace())) &&
      (getName() == null ?  
         xsdNamedComponent.getName() == null : 
         getName().equals(xsdNamedComponent.getName()));

  }

  public boolean hasNameAndTargetNamespace(String name, String targetNamespace)
  {
    return 
      (targetNamespace == null ?  
         getTargetNamespace() == null : 
         targetNamespace.equals(getTargetNamespace())) &&
      (name == null ?  
         getName() == null : 
         name.equals(getName()));
  }

  public boolean hasURI(String uri)
  {
    String theTargetNamespace = getTargetNamespace();
    if (theTargetNamespace == null)
    {
      theTargetNamespace = "";
    }
    String theName = getName();
    if (theName == null)
    {
      theName = "";
    }

    return 
      uri.startsWith(theTargetNamespace) && 
        uri.endsWith(theName) && 
        uri.length() == theName.length() + theTargetNamespace.length() + 1;
  }
}
