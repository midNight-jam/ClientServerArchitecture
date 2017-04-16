/**
 * Copyright 2016 Gash.
 *
 * This file and intellectual content is protected under the Apache License, version 2.0
 * (the "License"); you may not use this file except in compliance with the
 * License.  You may obtain a copy of the License at:
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.  See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */
package gash.router.server.tasks;

import java.util.concurrent.LinkedBlockingDeque;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import routing.Pipe.CommandMessage;


/**
/**
 * Processing of tasks
 * 
 * @author gash
 *
 */
public class TaskList {
	
	protected static Logger logger = LoggerFactory.getLogger("work");

	private LinkedBlockingDeque<CommandMessage> inbound;
	private int processed;
	private int balanced;
	private Rebalancer rebalance;
	
	public TaskList(){
		
	}
	public TaskList(Rebalancer rb) {
		rebalance = rb;
	}

	public void addTask(CommandMessage t) {
		inbound.add(t);
	}

	public int numEnqueued() {
		return inbound.size();
	}

	public int numProcessed() {
		return processed;
	}

	public int numBalanced() {
		return balanced;
	}
	
	public CommandMessage dequeue() {
		CommandMessage t = null;
		try {
			t = inbound.take();
			processed++;
		} catch (InterruptedException e) {
			logger.error("failed to dequeue a task", e);
		}
		return t;
	}

	/**
	 * task taken to be given to another node
	 * 
	 * @return
	 */
	/**
	public Task rebalance() {
		Task t = null;

		try {
			if (rebalance != null && !rebalance.allow())
				return t;

			t = inbound.take();
			balanced++;
		} catch (InterruptedException e) {
			logger.error("failed to rebalance a task", e);
		}
		return t;
	}
**/
	/**
	 * task taken to be processed by this node
	 * 
	 * @return
	 */
	/**
	
	
	**/
}
