/*
 * Copyright (C) 2020 Grakn Labs
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */

package grakn.benchmark.grakn.driver;

import grakn.benchmark.common.driver.TransactionalDbOperationFactory;
import grakn.client.Grakn;
import org.slf4j.Logger;

public class GraknOperationFactory extends TransactionalDbOperationFactory<GraknOperation> {

    private final Grakn.Session session;

    public GraknOperationFactory(Grakn.Session session, Logger logger) {
        super(logger);
        this.session = session;
    }

    @Override
    public GraknOperation newDbOperation(String tracker, long iteration, boolean trace) {
        return new GraknOperation(session, logger(), tracker, iteration, trace);
    }
}
