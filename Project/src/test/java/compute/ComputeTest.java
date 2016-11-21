package compute;

import java.util.ArrayList;
import java.util.List;

import com.hundsun.hot.portfolio.compute.implement.FluctuationComputeImpl;
import com.hundsun.hot.portfolio.compute.implement.SharpComputeImpl;
import com.hundsun.hot.portfolio.model.BaseEarnings;

public class ComputeTest {

	public static void main(String[] args) {
		testSharp();
	}
	
	private static void testSharp(){
		SharpComputeImpl sharpComputeImpl = new SharpComputeImpl();
		double[][] data = new double[1][];
		data[0] = new double[]{-0.00699, -0.01127, -0.01282, 0.00144, -0.01441, -0.00146, 0.00439, -0.00875, 0.01029, 0.00582, 0.01447, 0.00428, 0.00568, 0.00141, -0.00987, -0.01282, 0.00289, 0.0, -0.00576, -0.00579};
		double[] res = sharpComputeImpl.compute(data);
		System.out.println(res[0]);
	}
	
	private static void testFlu(){
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
