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
 * $Id: XSDDiagnosticImpl.java,v 1.1.2.1 2005/06/08 18:26:23 nickb Exp $
 */
package org.eclipse.xsd.impl;


import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.w3c.dom.Attr;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.xsd.XSDConcreteComponent;
import org.eclipse.xsd.XSDDiagnostic;
import org.eclipse.xsd.XSDDiagnosticSeverity;
import org.eclipse.xsd.XSDPackage;
import org.eclipse.xsd.XSDSchema;
import org.eclipse.xsd.util.XSDParser;


/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Diagnostic</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.xsd.impl.XSDDiagnosticImpl#getSeverity <em>Severity</em>}</li>
 *   <li>{@link org.eclipse.xsd.impl.XSDDiagnosticImpl#getMessage <em>Message</em>}</li>
 *   <li>{@link org.eclipse.xsd.impl.XSDDiagnosticImpl#getLocationURI <em>Location URI</em>}</li>
 *   <li>{@link org.eclipse.xsd.impl.XSDDiagnosticImpl#getLine <em>Line</em>}</li>
 *   <li>{@link org.eclipse.xsd.impl.XSDDiagnosticImpl#getColumn <em>Column</em>}</li>
 *   <li>{@link org.eclipse.xsd.impl.XSDDiagnosticImpl#getNode <em>Node</em>}</li>
 *   <li>{@link org.eclipse.xsd.impl.XSDDiagnosticImpl#getAnnotationURI <em>Annotation URI</em>}</li>
 *   <li>{@link org.eclipse.xsd.impl.XSDDiagnosticImpl#getComponents <em>Components</em>}</li>
 *   <li>{@link org.eclipse.xsd.impl.XSDDiagnosticImpl#getPrimaryComponent <em>Primary Component</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class XSDDiagnosticImpl 
  extends XSDConcreteComponentImpl 
  implements XSDDiagnostic
{
  /**
   * The default value of the '{@link #getSeverity() <em>Severity</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSeverity()
   * @generated
   * @ordered
   */
  protected static final XSDDiagnosticSeverity SEVERITY_EDEFAULT = XSDDiagnosticSeverity.FATAL_LITERAL;

  /**
   * The cached value of the '{@link #getSeverity() <em>Severity</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSeverity()
   * @generated
   * @ordered
   */
  protected XSDDiagnosticSeverity severity = SEVERITY_EDEFAULT;

  /**
   * The default value of the '{@link #getMessage() <em>Message</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getMessage()
   * @generated
   * @ordered
   */
  protected static final String MESSAGE_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getMessage() <em>Message</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getMessage()
   * @generated
   * @ordered
   */
  protected String message = MESSAGE_EDEFAULT;

  /**
   * The default value of the '{@link #getLocationURI() <em>Location URI</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getLocationURI()
   * @generated
   * @ordered
   */
  protected static final String LOCATION_URI_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getLocationURI() <em>Location URI</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getLocationURI()
   * @generated
   * @ordered
   */
  protected String locationURI = LOCATION_URI_EDEFAULT;

  /**
   * The default value of the '{@link #getLine() <em>Line</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getLine()
   * @generated
   * @ordered
   */
  protected static final int LINE_EDEFAULT = 1;

  /**
   * The cached value of the '{@link #getLine() <em>Line</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getLine()
   * @generated
   * @ordered
   */
  protected int line = LINE_EDEFAULT;

  /**
   * The default value of the '{@link #getColumn() <em>Column</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getColumn()
   * @generated
   * @ordered
   */
  protected static final int COLUMN_EDEFAULT = 1;

  /**
   * The cached value of the '{@link #getColumn() <em>Column</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getColumn()
   * @generated
   * @ordered
   */
  protected int column = COLUMN_EDEFAULT;

  /**
   * The default value of the '{@link #getNode() <em>Node</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getNode()
   * @generated
   * @ordered
   */
  protected static final Node NODE_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getNode() <em>Node</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getNode()
   * @generated
   * @ordered
   */
  protected Node node = NODE_EDEFAULT;

  /**
   * The default value of the '{@link #getAnnotationURI() <em>Annotation URI</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAnnotationURI()
   * @generated
   * @ordered
   */
  protected static final String ANNOTATION_URI_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getAnnotationURI() <em>Annotation URI</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAnnotationURI()
   * @generated
   * @ordered
   */
  protected String annotationURI = ANNOTATION_URI_EDEFAULT;

  /**
   * The cached value of the '{@link #getComponents() <em>Components</em>}' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getComponents()
   * @generated
   * @ordered
   */
  protected EList components = null;

  protected XSDDiagnosticImpl() 
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
    return XSDPackage.eINSTANCE.getXSDDiagnostic();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public XSDDiagnosticSeverity getSeverity()
  {
    return severity;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setSeverity(XSDDiagnosticSeverity newSeverity)
  {
    XSDDiagnosticSeverity oldSeverity = severity;
    severity = newSeverity == null ? SEVERITY_EDEFAULT : newSeverity;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, XSDPackage.XSD_DIAGNOSTIC__SEVERITY, oldSeverity, severity));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getMessage()
  {
    return message;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setMessage(String newMessage)
  {
    String oldMessage = message;
    message = newMessage;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, XSDPackage.XSD_DIAGNOSTIC__MESSAGE, oldMessage, message));
  }

  public String getLocation() 
  {
    return getLocationURI();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getLocationURIGen()
  {
    return locationURI;
  }

  public String getLocationURI() 
  {
    if (getLocationURIGen() == null)
    {
      XSDConcreteComponent thePrimaryComponent = getPrimaryComponent();
      if (thePrimaryComponent != null)
      {
        XSDSchema xsdSchema = thePrimaryComponent.getSchema();
        if (xsdSchema != null)
        {
          return xsdSchema.getSchemaLocation();
        }
      }
    }
    return getLocationURIGen();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setLocationURI(String newLocationURI)
  {
    String oldLocationURI = locationURI;
    locationURI = newLocationURI;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, XSDPackage.XSD_DIAGNOSTIC__LOCATION_URI, oldLocationURI, locationURI));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public int getLineGen()
  {
    return line;
  }

  public int getLine() 
  {
    Node theNode = getNode();
    if (theNode != null && theNode.getNodeType() == Node.ATTRIBUTE_NODE)
    {
      theNode = ((Attr)theNode).getOwnerElement();
    }
    if (theNode != null && XSDParser.getUserData(theNode) instanceof Map)
    {
      return XSDParser.getStartLine(theNode);
    }

    return getLineGen();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setLine(int newLine)
  {
    int oldLine = line;
    line = newLine;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, XSDPackage.XSD_DIAGNOSTIC__LINE, oldLine, line));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public int getColumnGen()
  {
    return column;
  }

  public int getColumn() 
  {
    Node theNode = getNode();
    if (theNode != null && theNode.getNodeType() == Node.ATTRIBUTE_NODE)
    {
      theNode = ((Attr)theNode).getOwnerElement();
    }
    if (theNode != null && XSDParser.getUserData(theNode) instanceof Map)
    {
      return  XSDParser.getStartColumn(theNode);
    }

    return getColumnGen();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setColumn(int newColumn)
  {
    int oldColumn = column;
    column = newColumn;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, XSDPackage.XSD_DIAGNOSTIC__COLUMN, oldColumn, column));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Node getNode()
  {
    return node;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setNode(Node newNode)
  {
    Node oldNode = node;
    node = newNode;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, XSDPackage.XSD_DIAGNOSTIC__NODE, oldNode, node));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getAnnotationURI()
  {
    return annotationURI;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setAnnotationURI(String newAnnotationURI)
  {
    String oldAnnotationURI = annotationURI;
    annotationURI = newAnnotationURI;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, XSDPackage.XSD_DIAGNOSTIC__ANNOTATION_URI, oldAnnotationURI, annotationURI));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList getComponents()
  {
    if (components == null)
    {
      components = new EObjectEList(XSDConcreteComponent.class, this, XSDPackage.XSD_DIAGNOSTIC__COMPONENTS);
    }
    return components;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated modifiable
   */
  public XSDConcreteComponent getPrimaryComponent()
  {
    List theComponents = getComponents();
    return 
      theComponents.size() > 0 ?
        (XSDConcreteComponent)theComponents.get(0) :
        null;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated modifiable
   */
  public void setPrimaryComponent(XSDConcreteComponent primaryComponent)
  {
    List theComponents = getComponents();
    if (primaryComponent == null)
    {
      theComponents.clear();
    }
    else if (theComponents.size() > 0)
    {
      theComponents.set(0, primaryComponent);
    }
    else
    {
      theComponents.add(primaryComponent);
    }
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
        case XSDPackage.XSD_DIAGNOSTIC__DIAGNOSTICS:
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
      case XSDPackage.XSD_DIAGNOSTIC__ELEMENT:
        return getElement();
      case XSDPackage.XSD_DIAGNOSTIC__CONTAINER:
        return getContainer();
      case XSDPackage.XSD_DIAGNOSTIC__ROOT_CONTAINER:
        return getRootContainer();
      case XSDPackage.XSD_DIAGNOSTIC__SCHEMA:
        return getSchema();
      case XSDPackage.XSD_DIAGNOSTIC__DIAGNOSTICS:
        return getDiagnostics();
      case XSDPackage.XSD_DIAGNOSTIC__SEVERITY:
        return getSeverity();
      case XSDPackage.XSD_DIAGNOSTIC__MESSAGE:
        return getMessage();
      case XSDPackage.XSD_DIAGNOSTIC__LOCATION_URI:
        return getLocationURI();
      case XSDPackage.XSD_DIAGNOSTIC__LINE:
        return new Integer(getLine());
      case XSDPackage.XSD_DIAGNOSTIC__COLUMN:
        return new Integer(getColumn());
      case XSDPackage.XSD_DIAGNOSTIC__NODE:
        return getNode();
      case XSDPackage.XSD_DIAGNOSTIC__ANNOTATION_URI:
        return getAnnotationURI();
      case XSDPackage.XSD_DIAGNOSTIC__COMPONENTS:
        return getComponents();
      case XSDPackage.XSD_DIAGNOSTIC__PRIMARY_COMPONENT:
        return getPrimaryComponent();
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
      case XSDPackage.XSD_DIAGNOSTIC__ELEMENT:
        setElement((Element)newValue);
        return;
      case XSDPackage.XSD_DIAGNOSTIC__DIAGNOSTICS:
        getDiagnostics().clear();
        getDiagnostics().addAll((Collection)newValue);
        return;
      case XSDPackage.XSD_DIAGNOSTIC__SEVERITY:
        setSeverity((XSDDiagnosticSeverity)newValue);
        return;
      case XSDPackage.XSD_DIAGNOSTIC__MESSAGE:
        setMessage((String)newValue);
        return;
      case XSDPackage.XSD_DIAGNOSTIC__LOCATION_URI:
        setLocationURI((String)newValue);
        return;
      case XSDPackage.XSD_DIAGNOSTIC__LINE:
        setLine(((Integer)newValue).intValue());
        return;
      case XSDPackage.XSD_DIAGNOSTIC__COLUMN:
        setColumn(((Integer)newValue).intValue());
        return;
      case XSDPackage.XSD_DIAGNOSTIC__NODE:
        setNode((Node)newValue);
        return;
      case XSDPackage.XSD_DIAGNOSTIC__ANNOTATION_URI:
        setAnnotationURI((String)newValue);
        return;
      case XSDPackage.XSD_DIAGNOSTIC__COMPONENTS:
        getComponents().clear();
        getComponents().addAll((Collection)newValue);
        return;
      case XSDPackage.XSD_DIAGNOSTIC__PRIMARY_COMPONENT:
        setPrimaryComponent((XSDConcreteComponent)newValue);
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
      case XSDPackage.XSD_DIAGNOSTIC__ELEMENT:
        setElement(ELEMENT_EDEFAULT);
        return;
      case XSDPackage.XSD_DIAGNOSTIC__DIAGNOSTICS:
        getDiagnostics().clear();
        return;
      case XSDPackage.XSD_DIAGNOSTIC__SEVERITY:
        setSeverity(SEVERITY_EDEFAULT);
        return;
      case XSDPackage.XSD_DIAGNOSTIC__MESSAGE:
        setMessage(MESSAGE_EDEFAULT);
        return;
      case XSDPackage.XSD_DIAGNOSTIC__LOCATION_URI:
        setLocationURI(LOCATION_URI_EDEFAULT);
        return;
      case XSDPackage.XSD_DIAGNOSTIC__LINE:
        setLine(LINE_EDEFAULT);
        return;
      case XSDPackage.XSD_DIAGNOSTIC__COLUMN:
        setColumn(COLUMN_EDEFAULT);
        return;
      case XSDPackage.XSD_DIAGNOSTIC__NODE:
        setNode(NODE_EDEFAULT);
        return;
      case XSDPackage.XSD_DIAGNOSTIC__ANNOTATION_URI:
        setAnnotationURI(ANNOTATION_URI_EDEFAULT);
        return;
      case XSDPackage.XSD_DIAGNOSTIC__COMPONENTS:
        getComponents().clear();
        return;
      case XSDPackage.XSD_DIAGNOSTIC__PRIMARY_COMPONENT:
        setPrimaryComponent((XSDConcreteComponent)null);
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
      case XSDPackage.XSD_DIAGNOSTIC__ELEMENT:
        return ELEMENT_EDEFAULT == null ? element != null : !ELEMENT_EDEFAULT.equals(element);
      case XSDPackage.XSD_DIAGNOSTIC__CONTAINER:
        return getContainer() != null;
      case XSDPackage.XSD_DIAGNOSTIC__ROOT_CONTAINER:
        return getRootContainer() != null;
      case XSDPackage.XSD_DIAGNOSTIC__SCHEMA:
        return getSchema() != null;
      case XSDPackage.XSD_DIAGNOSTIC__DIAGNOSTICS:
        return diagnostics != null && !diagnostics.isEmpty();
      case XSDPackage.XSD_DIAGNOSTIC__SEVERITY:
        return severity != SEVERITY_EDEFAULT;
      case XSDPackage.XSD_DIAGNOSTIC__MESSAGE:
        return MESSAGE_EDEFAULT == null ? message != null : !MESSAGE_EDEFAULT.equals(message);
      case XSDPackage.XSD_DIAGNOSTIC__LOCATION_URI:
        return LOCATION_URI_EDEFAULT == null ? locationURI != null : !LOCATION_URI_EDEFAULT.equals(locationURI);
      case XSDPackage.XSD_DIAGNOSTIC__LINE:
        return line != LINE_EDEFAULT;
      case XSDPackage.XSD_DIAGNOSTIC__COLUMN:
        return column != COLUMN_EDEFAULT;
      case XSDPackage.XSD_DIAGNOSTIC__NODE:
        return NODE_EDEFAULT == null ? node != null : !NODE_EDEFAULT.equals(node);
      case XSDPackage.XSD_DIAGNOSTIC__ANNOTATION_URI:
        return ANNOTATION_URI_EDEFAULT == null ? annotationURI != null : !ANNOTATION_URI_EDEFAULT.equals(annotationURI);
      case XSDPackage.XSD_DIAGNOSTIC__COMPONENTS:
        return components != null && !components.isEmpty();
      case XSDPackage.XSD_DIAGNOSTIC__PRIMARY_COMPONENT:
        return getPrimaryComponent() != null;
    }
    return eDynamicIsSet(eFeature);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated modifiable
   */
  public void unsetPrimaryComponent() 
  {
    List theComponents = getComponents();
    theComponents.clear();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated modifiable
   */
  public boolean isSetPrimaryComponent() 
  {
    List theComponents = getComponents();
    return !theComponents.isEmpty();
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
    result.append(" (severity: ");
    result.append(severity);
    result.append(", message: ");
    result.append(message);
    result.append(", locationURI: ");
    result.append(locationURI);
    result.append(", line: ");
    result.append(line);
    result.append(", column: ");
    result.append(column);
    result.append(", node: ");
    result.append(node);
    result.append(", annotationURI: ");
    result.append(annotationURI);
    result.append(')');
    return result.toString();
  }

}
