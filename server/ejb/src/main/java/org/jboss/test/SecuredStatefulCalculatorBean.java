/*
 * JBoss, Home of Professional Open Source.
 * Copyright 2013, Red Hat, Inc., and individual contributors
 * as indicated by the @author tags. See the copyright.txt file in the
 * distribution for a full listing of individual contributors.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */

package org.jboss.test;

import javax.annotation.security.RolesAllowed;
import javax.ejb.Remote;
import javax.ejb.Stateful;

import org.jboss.ejb3.annotation.SecurityDomain;

@Stateful
@Remote(RemoteCalculator.class)
@SecurityDomain("TestDomain")
@RolesAllowed("TestRole")
public class SecuredStatefulCalculatorBean implements RemoteCalculator{

    private int current = 0;

    public int add(int a, int b) {
//        System.err.println(this.getClass().getSimpleName()+".add");
        int val = a+b;
        current+=val;
        return val;
    }

    public int subtract(int a, int b) {
//        System.err.println(this.getClass().getSimpleName()+".substract");
        int val = a - b;
        this.current-=val;
        return val;
    }

    public int current() {
//        System.err.println(this.getClass().getSimpleName()+".current");
        return this.current;
    }

}