package compute;

import java.util.ArrayList;
import java.util.List;

import com.hundsun.hot.portfolio.compute.implement.FluctuationComputeImpl;
import com.hundsun.hot.portfolio.model.BaseEarnings;

public class ComputeTest {

	public static void main(String[] args) {
		FluctuationComputeImpl fluctuationCompute = new FluctuationComputeImpl();
		List<BaseEarnings> list = new ArrayList<>();
		BaseEarnings baseEarnings = new BaseEarnings();
		baseEarnings.setStockEarnings(1.23);

		BaseEarnings baseEarnings2 = new BaseEarnings();
		baseEarnings2.setStockEarnings(-1.23);

		list.add(baseEarnings);
		list.add(baseEarnings2);

		double res = fluctuationCompute.computeSingle(list);
		System.out.println(res);

	}

}
