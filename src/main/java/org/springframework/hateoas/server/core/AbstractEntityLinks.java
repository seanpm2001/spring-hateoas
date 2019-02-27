/*
 * Copyright 2012 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springframework.hateoas.server.core;

import org.springframework.hateoas.Identifiable;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.EntityLinks;
import org.springframework.hateoas.server.LinkBuilder;
import org.springframework.util.Assert;

/**
 * Implementation base class to delegate the higher level methods of {@link EntityLinks} by delegating to the more fine
 * grained ones to reduce the implementation effort for actual implementation classes.
 * 
 * @author Oliver Gierke
 */
public abstract class AbstractEntityLinks implements EntityLinks {

	/* 
	 * (non-Javadoc)
	 * @see org.springframework.hateoas.EntityLinks#getLinkToSingleResource(org.springframework.hateoas.Identifiable)
	 */
	@Override
	public Link linkToItemResource(Identifiable<?> entity) {
		Assert.notNull(entity, "Entity must not be null!");
		return linkToItemResource(entity.getClass(), entity.getId());
	}

	/* 
	 * (non-Javadoc)
	 * @see org.springframework.hateoas.EntityLinks#linkForSingleResource(java.lang.Class, java.lang.Object)
	 */
	@Override
	public LinkBuilder linkForItemResource(Class<?> type, Object id) {
		return linkFor(type).slash(id);
	}

	/* 
	 * (non-Javadoc)
	 * @see org.springframework.hateoas.EntityLinks#linkForSingleResource(org.springframework.hateoas.Identifiable)
	 */
	@Override
	public LinkBuilder linkForItemResource(Identifiable<?> entity) {
		Assert.notNull(entity, "Entity must not be null!");
		return linkForItemResource(entity.getClass(), entity.getId());
	}
}
