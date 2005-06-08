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
 * $Id: XSDResourceFactoryImpl.java,v 1.2.2.1 2005/06/08 18:26:24 nickb Exp $
 */
package org.eclipse.xsd.util;


import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceFactoryImpl;


/**
 * The <b>Resource Factory</b> implementation for the model.
 * This class is the XSD resource factory that knows how to parse .xsd files to produce a MOF model.
 * This class is not intended for subclassing outside of the model implementation;
 * it is intended to be used as is with the Resource framework. 
 * @see XSDResourceImpl
 * @see XSDParser
 */
public class XSDResourceFactoryImpl extends ResourceFactoryImpl
{
  /**
   * Creates an instance.
   */
  public XSDResourceFactoryImpl()
  {
    super();
  }

  /**
   * Creates an {@link XSDResourceImpl}.
   * @param uri the URI of the new resource.
   * @return an XSDResourceImpl.
   */
  public Resource createResource(URI uri)
  {
    return new XSDResourceImpl(uri);
  }
}
